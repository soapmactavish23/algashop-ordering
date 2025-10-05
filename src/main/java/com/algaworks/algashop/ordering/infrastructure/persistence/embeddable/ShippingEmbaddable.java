package com.algaworks.algashop.ordering.infrastructure.persistence.embeddable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ShippingEmbaddable {

    private BigDecimal cost;
    private LocalDate expectedDate;

    @Embedded
    private AddressEmbeddable address;

    @Embedded
    private RecipientEmbedabble recipient;

}
