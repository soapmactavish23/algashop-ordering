package com.algaworks.algashop.ordering.core.domain.model.product;

import com.algaworks.algashop.ordering.infrastructure.adapters.out.web.product.client.http.ProductCatalogAPIClient;
import com.algaworks.algashop.ordering.utils.TestcontainerPostgreSQLConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Import(TestcontainerPostgreSQLConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProductCatalogServiceTest {

    @Autowired
    private ProductCatalogService productCatalogService;

    @Autowired
    private ProductCatalogAPIClient productCatalogAPIClient;

    @Test
    void shouldHandleConcurrency() throws InterruptedException {
        UUID rawProductId = UUID.randomUUID();
        ProductId productId = new ProductId(rawProductId);
        Mockito.when(productCatalogAPIClient.getById(rawProductId)).thenReturn(null);

        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
            executorService.submit(() -> productCatalogService.ofId(productId));
            executorService.submit(() -> productCatalogService.ofId(productId));
            executorService.submit(() -> productCatalogService.ofId(productId));
            executorService.submit(() -> productCatalogService.ofId(productId));
            executorService.submit(() -> productCatalogService.ofId(productId));
            executorService.submit(() -> productCatalogService.ofId(productId));
            executorService.awaitTermination(30, TimeUnit.SECONDS);
            executorService.shutdown();
        }
    }

}