package com.algaworks.algashop.ordering.core.ports.out.order;

import com.algaworks.algashop.ordering.core.application.OutboundIntegrationCommand;

public interface ForPublishingOrderIntegrationCommands {
	void send(OutboundIntegrationCommand command);
}
