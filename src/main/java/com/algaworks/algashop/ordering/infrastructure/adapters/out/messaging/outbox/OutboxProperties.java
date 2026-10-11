package com.algaworks.algashop.ordering.infrastructure.adapters.out.messaging.outbox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("algashop.messaging.outbox")
public class OutboxProperties {

    private Dispatcher dispatcher = new Dispatcher();

    public static class Dispatcher {
        private boolean enabled = false;
    }

}
