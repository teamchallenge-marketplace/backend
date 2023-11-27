package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItem {

    private String productId;

    private int amount;

    private BigDecimal price;

}
