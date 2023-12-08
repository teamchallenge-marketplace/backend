package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Price {

    private BigDecimal price;

    private String currency;

    private BigDecimal salePrice;

    private Date saleDueTo;

}
