package com.tvo.orderservice.clients;

import com.tvo.orderservice.dto.ProductDto;
import com.tvo.orderservice.exception.ExternalServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
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

        ProductDto[] response =
                restClient.get()
                        .uri(productUrl +
                                        "/products/customer/{id}",
                                customerId)
                        .retrieve()
                        .onStatus(
                                HttpStatusCode::isError,
                                (req, res) -> {
                                    throw new ExternalServiceException(
                                            "Product Service Exception");
                                })
                        .body(ProductDto[].class);

         return response == null
                ? List.of()
                : Arrays.asList(response);
    }
}