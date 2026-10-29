package com.tvo.orderservice.clients;

import com.tvo.orderservice.dto.ProductDto;
import com.tvo.orderservice.exception.ExternalServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductClient {

    private final RestClient restClient;

    @Value("${services.product.url}")
    private String productUrl;

    public ProductClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<ProductDto> getProducts(
            String customerId) {
        try {

            System.out.println("productUrl = " + productUrl);

            ProductDto[] products = restClient.get()
                    .uri(productUrl + "/products/customer/{customerId}", customerId)
                    .retrieve()
                    .body(ProductDto[].class);

            return products != null
                    ? Arrays.asList(products)
                    : Collections.emptyList();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}