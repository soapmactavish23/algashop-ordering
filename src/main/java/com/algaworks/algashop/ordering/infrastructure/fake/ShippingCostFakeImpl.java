package com.algaworks.algashop.ordering.infrastructure.fake;

import com.algaworks.algashop.ordering.domain.model.service.ShippingCostService;
import com.algaworks.algashop.ordering.domain.model.valueobject.Money;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.time.LocalDate;

@ConditionalOnProperty(name = "algashop.integrations.shipping.provider", havingValue = "FAKE")
public class ShippingCostFakeImpl implements ShippingCostService {
    @Override
    public CalculationResult calculate(CalculationRequest request) {
        return new CalculationResult(new Money("20"),
                LocalDate.now().plusDays(5));
    }
}
