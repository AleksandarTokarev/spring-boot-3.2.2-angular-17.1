package io.proton.protonorders.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    private Long id;
    private Long orderId;
    private String customerId;
    private String customerName;
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal totalPrice;
    private String date;
}
