package com.algaworks.algashop.ordering.infrastructure.client.rapidex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryCostResponse {

    private String deliveryCost;
    private Integer estimatedDaysToDeliver;

}
