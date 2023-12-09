package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.com.marketplace.backend.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String customerId;

    private String sellerId;

    private Set<OrderItem> orderItems;

    private BigDecimal totalPrice;

    private OrderStatus orderStatus;

    private LocalDateTime timestamp;

}
