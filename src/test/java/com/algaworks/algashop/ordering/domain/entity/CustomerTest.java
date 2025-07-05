package com.algaworks.algashop.ordering.domain.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class CustomerTest {

    @Test
    public void testingCustomer() {
        Customer customer = new Customer(
                UUID.randomUUID(),
                "John Doe",
                LocalDate.of(1991, 7, 5),
                "john@email.com",
                "123-123-1231",
                "255-08-0578",
                true,
                OffsetDateTime.now()
        );

        customer.addLoyaltyPoints(10);
    }

}
