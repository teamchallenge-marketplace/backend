package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@Document(collection = "products")
@CompoundIndex(name = "product_code", def = "{sellerId: 1, mpn: 1, gtin: 1}", unique = true)
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private String mpn; //Manufacturer part number - product code assigned by manufacturer(seller)

    private String gtin; // International product code GTIN-13

    private Set<String> images;

    private String brand;

    private Category category;

    private Price price;

    private int totalAmount;

    private boolean isAvailable;

    private Map<String, String> specificDetails;

    private String sellerId;

}
