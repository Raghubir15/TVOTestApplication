package com.tvo.orderservice.service;

import com.tvo.orderservice.clients.ActivationClient;
import com.tvo.orderservice.clients.ProductClient;
import com.tvo.orderservice.dto.ActivationDto;
import com.tvo.orderservice.dto.CustomerProductDto;
import com.tvo.orderservice.dto.CustomerProductsResponse;
import com.tvo.orderservice.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final ProductClient productClient;
    private final ActivationClient activationClient;

    public OrderService(
            ProductClient productClient, ActivationClient activationClient) {

        this.productClient = productClient;
        this.activationClient = activationClient;
    }

    public CustomerProductsResponse getProducts(
            String customerId) {

        List<ProductDto> products = productClient.getProducts(customerId);

        List<CustomerProductDto> result =
                products.stream().map(product -> {
                    ActivationDto activation =
                            activationClient.getActivation(
                                    product.getProductId());

                    return new CustomerProductDto(product.getProductId(),
                            product.getProductName(),
                            activation.isActive());
                }).toList();
        return new CustomerProductsResponse(
                customerId,
                result
        );
    }
}
