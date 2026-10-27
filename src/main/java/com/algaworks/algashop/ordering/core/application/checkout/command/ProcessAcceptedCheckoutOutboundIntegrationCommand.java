package com.algaworks.algashop.ordering.core.application.checkout.command;

import com.algaworks.algashop.ordering.core.application.OutboundIntegrationCommand;
import com.algaworks.algashop.ordering.core.application.order.snapshot.OrderSnapshot;
import com.algaworks.algashop.ordering.core.domain.model.IdGenerator;
import lombok.*;

import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessAcceptedCheckoutOutboundIntegrationCommand
		implements OutboundIntegrationCommand {
	private UUID idempotencyKey = IdGenerator.generateTimeBasedUUID();
	private OrderSnapshot order;

	public ProcessAcceptedCheckoutOutboundIntegrationCommand(OrderSnapshot order) {
		this.order = order;
	}

	@Override
	public String getAggregateId() {
		return order.orderId();
	}

	@Override
	public UUID getIdempotencyKey() {
		return idempotencyKey;
	}
}
