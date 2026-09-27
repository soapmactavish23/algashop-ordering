package com.algaworks.algashop.ordering.infrastructure.adapters.out.persistence.idempotency;

import com.algaworks.algashop.ordering.core.ports.out.idempotency.ForGuardingIdempotency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ForGuardingIdempotencyJpaImpl implements ForGuardingIdempotency {

    private final ProcessedMessageRepository repository;
    private final TransactionTemplate transactionTemplate;

    @Override
    public boolean runOnce(UUID idempotencyKey, Runnable work) {
        return Boolean.TRUE.equals(transactionTemplate.execute(status -> {
            try {
                repository.saveAndFlush(new ProcessedMessage(idempotencyKey));
            } catch (DataIntegrityViolationException e) {
                status.setRollbackOnly();
                log.warn("Duplicate execution skipped: idempotencyKey={}", idempotencyKey);
                return false;
            }
            work.run();
            return true;
        }));
    }
}
