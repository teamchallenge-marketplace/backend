package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;

@Data
@Builder
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    /*
        Manufacturer part number - product code assigned by manufacturer(seller)
        MPN should remain the same for products with different size, color and other not valuable props
        !!! red T-Shirt and green T-Shirt should have the same mpn value !!!
     */
    private String mpn;

    private String gtin; // International product code GTIN-13 for books ISBN-13

    private Set<String> images;

    private String brand;

    private Category category;

    private Price price;

    private int totalAmount;

    private boolean isAvailable;

    private Map<String, String> specificDetails;

    private String sellerId;

}
