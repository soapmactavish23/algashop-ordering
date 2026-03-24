package com.algaworks.algashop.ordering.core.model.order;

import com.algaworks.algashop.ordering.core.domain.model.order.Order;
import com.algaworks.algashop.ordering.core.domain.model.order.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderIsReadyTest {

    @Test
    void givenOrderWithStatusPaid_whenIsReady_shouldReturnFalse() {
        Order order = OrderTestDataBuilder.anOrder().status(OrderStatus.PAID).build();

        Assertions.assertThat(order.isReady()).isFalse();
    }

    @Test
    void givenOrderWithStatusDraft_whenIsReady_shouldReturnFalse() {
        Order order = OrderTestDataBuilder.anOrder().status(OrderStatus.DRAFT).build();

        Assertions.assertThat(order.isReady()).isFalse();
    }

    @Test
    void givenOrderWithStatusCanceled_whenIsReady_shouldReturnFalse() {
        Order order = OrderTestDataBuilder.anOrder().status(OrderStatus.CANCELED).build();

        Assertions.assertThat(order.isReady()).isFalse();
    }
}