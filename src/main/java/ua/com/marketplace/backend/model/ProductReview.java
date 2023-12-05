package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "reviews")
public class ProductReview {

    @Id
    private int id;

    private String senderId;

    private String receiverId;

    private String productId;

    private String message;

    private float ratePoints;

    private Date timestamp;

}
