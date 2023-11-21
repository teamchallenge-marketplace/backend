package ua.com.marketplace.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.com.marketplace.backend.model.enums.Availability;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Document(collection = "products")
@CompoundIndex(name = "product_code", def = "{sellerId: 1, mpn: 1, gtin: 1}", unique = true)
public abstract class Product {

    @Id
    protected String id;

    protected String name;

    protected String description;

    protected String mpn; //Manufacturer part number - product code assigned by manufacturer(seller)

    protected String gtin; // International product code GTIN-13

    protected Set<String> images;

    protected String brand;

    protected Category category;

    protected BigDecimal price;

    protected Availability availability;

    protected String sellerId;

}
