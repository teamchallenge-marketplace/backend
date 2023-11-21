package ua.com.marketplace.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Clothes extends Product {

    private String size;

    private String color;

    private String material;

    private String gender;

    private String ageGroup;

    private String sizeSystem;

}
