package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "reviews")
public class ProductReview {

    @Id
    private String id;

    private String productId;

    private String reviewerId;

}
