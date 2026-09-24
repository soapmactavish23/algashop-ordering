package com.algaworks.algashop.ordering.infrastructure.config.kafka;

import com.algaworks.algashop.ordering.core.domain.model.DomainException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.ExponentialBackOff;

@Configuration
public class KafkaConfig {

    @Bean
    public DefaultErrorHandler defaultErrorHandler() {
        long interval = 2000L;
        double multipler = 2;
        long maxRetries = 3L;

        ExponentialBackOff exponentialBackOff = new ExponentialBackOff(interval, multipler);
        exponentialBackOff.setMaxAttempts(maxRetries);
        DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler(exponentialBackOff);

        defaultErrorHandler.addNotRetryableExceptions(DomainException.class);

        return defaultErrorHandler;
    }

}
