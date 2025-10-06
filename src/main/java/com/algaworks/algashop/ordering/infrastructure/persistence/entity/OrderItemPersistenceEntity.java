package com.algaworks.algashop.ordering.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@Table(name = "order_item")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItemPersistenceEntity {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private UUID productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal totalAmount;

    @JoinColumn
    @ManyToOne(optional = false)
    private OrderPersistenceEntity order;

    public OrderPersistenceEntity order() {
        return order;
    }

    public Long getOrderId() {
        if(getOrder() == null) {
            return null;
        }

        return getOrder().getId();
    }

}
