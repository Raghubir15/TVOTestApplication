package com.tvo.productservice.Exception;

public class ProductNotFoundException
        extends RuntimeException {

    public ProductNotFoundException(
            String customerId) {
        super("No products found for customer "+ customerId
        );
    }
}
