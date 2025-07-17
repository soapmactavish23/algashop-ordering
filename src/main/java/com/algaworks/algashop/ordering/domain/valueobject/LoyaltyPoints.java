package com.algaworks.algashop.ordering.domain.valueobject;

import java.util.Objects;

public record LoyaltyPoints(Integer value) implements Comparable<LoyaltyPoints> {
    public LoyaltyPoints() {
        this(0);
    }

    public LoyaltyPoints(Integer value) {
        Objects.requireNonNull(value);
        if(value < 0) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public LoyaltyPoints add(Integer value) {
        return add(new LoyaltyPoints(value));
    }

    public LoyaltyPoints add(LoyaltyPoints loLayoltyPoints) {
        Objects.requireNonNull(loLayoltyPoints);
        if(loLayoltyPoints.value() < 0) {
            throw new IllegalArgumentException();
        }

        return new LoyaltyPoints(this.value + loLayoltyPoints.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(LoyaltyPoints o) {
        return this.value().compareTo(o.value());
    }
}
