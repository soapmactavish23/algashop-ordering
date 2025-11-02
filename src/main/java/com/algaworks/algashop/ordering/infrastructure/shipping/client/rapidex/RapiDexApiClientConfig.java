package com.algaworks.algashop.ordering.infrastructure.shipping.client.rapidex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RapiDexApiClientConfig {

    @Bean
    public RapiDexAPIClient rapiDexAPIClient(RestClient.Builder builder,
                                             @Value("${algashop.integrations.rapidex.url}") String rapiDexUrl) {
        RestClient restClient = builder.baseUrl(rapiDexUrl).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();
        return proxyFactory.createClient(RapiDexAPIClient.class);
    }

}
