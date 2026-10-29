package com.tvo.orderservice.service;

import com.tvo.orderservice.clients.ActivationClient;
import com.tvo.orderservice.clients.ProductClient;
import com.tvo.orderservice.dto.*;
import com.tvo.orderservice.dto.CustomerProductDto;
import com.tvo.orderservice.dto.CustomerProductsResponse;
import com.tvo.orderservice.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<CustomerProductDto> response = new ArrayList<>();

        for (ProductDto product : products) {

            ActivationDto activation =
                    activationClient.getActivation(
                            product.getProductId());

            CustomerProductDto customerProduct =
                    new CustomerProductDto(
                            product.getProductId(),
                            product.getProductName(),
                            activation.getStatus());

            response.add(customerProduct);
        }

        return new CustomerProductsResponse(
                customerId,
                response
        );
    }
}
