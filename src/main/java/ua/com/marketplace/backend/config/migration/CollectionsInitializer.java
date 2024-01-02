package ua.com.marketplace.backend.config.migration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.mongock.api.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import ua.com.marketplace.backend.model.Category;
import ua.com.marketplace.backend.model.OfficeContacts;
import ua.com.marketplace.backend.model.SellerInfo;
import ua.com.marketplace.backend.model.User;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        insertManufacturers();
        insertProductCategories();
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

    private void insertManufacturers() throws IOException {
        JsonNode jsonNode = objectMapper.readValue(
                new File("src/main/resources/static/manufacturers-data.json"),
                JsonNode.class
        );

        List<SellerInfo> sellerInfoList = StreamSupport.stream(jsonNode.spliterator(), true)
                .map(sellerJsonNode -> {
                    try {
                        SellerInfo sellerInfo = objectMapper.treeToValue(sellerJsonNode, SellerInfo.class);

                        JsonNode contactsNode = sellerJsonNode.get("contacts");

                        Set<OfficeContacts> officeContacts = StreamSupport.stream(contactsNode.spliterator(), true)
                                .map(contactJsonNode -> {
                                    try {
                                        return objectMapper.treeToValue(contactJsonNode, OfficeContacts.class);
                                    } catch (JsonProcessingException e) {
                                        throw new RuntimeException(e);
                                    }
                                }).collect(Collectors.toSet());

                        sellerInfo.setContacts(officeContacts);

                        return sellerInfo;
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException("Error with mapping JSON to Java object", e);
                    }
                })
                .collect(Collectors.toList());


        mongoTemplate.insert(sellerInfoList, collections[5]);
    }

    private void insertProductCategories() throws IOException {
        JsonNode jsonNode = objectMapper.readValue(
                new File("src/main/resources/static/product-categories.json"),
                JsonNode.class
        );

        List<Category> categories = StreamSupport.stream(jsonNode.spliterator(), true)
                .map(categoryNode -> {
                    try {
                        return objectMapper.treeToValue(categoryNode, Category.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException("Error with mapping JSON to Java object", e);
                    }
                }).toList();

        mongoTemplate.insert(categories, collections[2]);
    }
}
