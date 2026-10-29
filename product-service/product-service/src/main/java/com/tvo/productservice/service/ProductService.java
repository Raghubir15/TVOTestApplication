package com.tvo.productservice.service;

import com.tvo.productservice.Exception.ProductNotFoundException;
import com.tvo.productservice.dto.ProductResponse;
import com.tvo.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponse> getProducts(
            String customerId) {

        List<ProductResponse> response =
                repository.findByCustomerId(customerId)
                        .stream()
                        .map(product ->
                                new ProductResponse(
                                        product.getProductId(),
                                        product.getProductName()))
                        .toList();
        if(response.isEmpty()) {
            throw new ProductNotFoundException(customerId);
        }

        return response;
    }
}
