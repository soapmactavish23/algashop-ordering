package com.algaworks.algashop.ordering.infrastructure.adapters.in.messaging.kafka.order;

import com.algaworks.algashop.ordering.core.application.checkout.command.ProcessAcceptedCheckoutIntegrationCommand;
import com.algaworks.algashop.ordering.core.ports.in.checkout.ForProcessingCheckoutAccepted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@KafkaListener(
        id = "ordering.order-commands",
        topics = "#{algaShopMessagingKafkaProperties.orderEventTopicName}"
)
public class KafkaOrderIntegrationCommandListener {

    private final ForProcessingCheckoutAccepted forProcessingCheckoutAccepted;

    @KafkaHandler
    public void handle(@Payload ProcessAcceptedCheckoutIntegrationCommand integrationEvent,
                       @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) String messageKey,
                       @Header(value = KafkaHeaders.RECEIVED_PARTITION, required = false) Integer partition,
                       @Header(value = KafkaHeaders.OFFSET, required = false) Integer offset) {
        logReceived(integrationEvent, messageKey, partition, offset);
        forProcessingCheckoutAccepted.process(integrationEvent);
    }

    @KafkaHandler(isDefault = true)
    public void handle(Object integrationCommand) {
        log.info("Order integration command ignored: {}", integrationCommand.getClass().getSimpleName());
    }


    private void logReceived(Object event, String messageKey, Integer partition, Integer offset) {
        log.info("Received {} | key={} | partiton={} | offset={} | thread={}",
                event.getClass().getSimpleName(), messageKey, partition, offset,
                Thread.currentThread().getName());
    }
}
