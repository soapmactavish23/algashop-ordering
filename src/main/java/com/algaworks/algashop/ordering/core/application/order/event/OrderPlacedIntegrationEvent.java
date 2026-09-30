package com.algaworks.algashop.ordering.core.application.order.event;

import com.algaworks.algashop.ordering.core.application.IntegrationEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedIntegrationEvent implements IntegrationEvent {
    private String orderId;
    private UUID customerId;
    private OffsetDateTime placedAt;

    @Override
    public String getAggregateId() {
        return orderId;
    }
}
