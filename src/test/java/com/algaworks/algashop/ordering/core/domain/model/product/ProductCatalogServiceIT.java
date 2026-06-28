package com.algaworks.algashop.ordering.core.domain.model.product;

import com.algaworks.algashop.ordering.infrastructure.adapters.out.web.product.client.http.ProductCatalogAPIClient;
import com.algaworks.algashop.ordering.infrastructure.adapters.out.web.product.client.http.ProductResponse;
import com.algaworks.algashop.ordering.utils.TestcontainerPostgreSQLConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Import(TestcontainerPostgreSQLConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProductCatalogServiceIT {

    @Autowired
    private ProductCatalogService productCatalogService;

    @MockitoBean
    private ProductCatalogAPIClient productCatalogAPIClient;

    @Test
    void shouldHandleConcurrency() throws InterruptedException {
        UUID rawProductId = UUID.randomUUID();
        ProductId productId = new ProductId(rawProductId);

        ProductResponse response = new ProductResponse();
        response.setId(rawProductId);
        response.setName("Produto Teste");
        response.setInStock(true);
        response.setSalePrice(new BigDecimal("100.00"));

        Mockito.when(productCatalogAPIClient.getById(rawProductId))
                .thenReturn(response);

        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 6; i++) {
                executorService.submit(() -> productCatalogService.ofId(productId));
            }

            executorService.shutdown();
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        }

        Mockito.verify(productCatalogAPIClient, Mockito.times(6))
                .getById(rawProductId);
    }
}