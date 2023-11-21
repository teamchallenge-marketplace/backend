package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document(collection = "categories")
public class Category {

    private String id;

    private String parent;

    private Set<String> ancestors;
}
