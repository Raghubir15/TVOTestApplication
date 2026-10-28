package com.tvo.activationservice.exception;

public class ActivationNotFoundException
        extends RuntimeException {

    public ActivationNotFoundException(
            String productId) {

        super(
                "Activation not found for product : "
                        + productId
        );
    }
}
