package ua.com.marketplace.backend.config.migration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.mongock.api.annotations.*;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import ua.com.marketplace.backend.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@ChangeUnit(id = "initialization", order = "001")
@RequiredArgsConstructor
public class CollectionsInitializer {

    private final MongoTemplate mongoTemplate;

    private final ObjectMapper objectMapper;

    private static final String[] collections = {"users", "products", "categories", "orders", "reviews", "manufacturers"};


    @BeforeExecution
    public void before() {
        Arrays.stream(collections).forEach(mongoTemplate::createCollection);
    }

    @RollbackBeforeExecution
    public void rollbackBefore() {
        Arrays.stream(collections).forEach(mongoTemplate::dropCollection);
    }

    @Execution
    public void insertData() throws IOException {
        insertUsers();
    }

    @RollbackExecution
    public void rollback() {

    }

    private void insertUsers() throws IOException {
        JsonNode jsonNode = objectMapper.readValue(
                new File("src/main/resources/static/users-data.json"),
                JsonNode.class
        );

        List<User> users = new ArrayList<>();

        Iterator<JsonNode> jsonNodeIterator = jsonNode.elements();
        while (jsonNodeIterator.hasNext()) {
            JsonNode tempNode = jsonNodeIterator.next();
            User user = objectMapper.treeToValue(tempNode, User.class);

            users.add(user);
        }

        mongoTemplate.insert(users, collections[0]);
    }

}
