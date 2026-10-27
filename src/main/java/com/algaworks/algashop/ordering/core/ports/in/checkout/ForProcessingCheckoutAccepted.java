package com.algaworks.algashop.ordering.core.ports.in.checkout;

import com.algaworks.algashop.ordering.core.application.checkout.command.ProcessAcceptedCheckoutOutboundIntegrationCommand;

public interface ForProcessingCheckoutAccepted {
	void process(ProcessAcceptedCheckoutOutboundIntegrationCommand integrationCommand);
}
