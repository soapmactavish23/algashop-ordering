package com.algaworks.algashop.ordering.infrastructure.adapters.out.messaging.outbox;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "algashop.messaging.outbox.dispatcher.enabled", havingValue = "true")
public class OutboxDispatcher {

    private final OutboxMessageRepository repository;
    private final OutboxKafkaSender sender;
    private final OutboxProperties properties;
    private final TransactionTemplate transactionTemplate;

    @SchedulerLock(name = "outboxDispatcher", lockAtMostFor = "PT5M")
    @Scheduled(fixedDelayString = "${algashop.messaging.outbox.poll-interval}")
    public void dispatch() {
        List<OutboxMessage> batch = repository.findBatch(PageRequest.of(0, properties.getBatchSize()));

        for (OutboxMessage message : batch) {
            sender.send(message);
            transactionTemplate.executeWithoutResult(_ -> repository.deleteMessage(message.getId()));
        }
    }

}
