package com.tvo.activationservice.dto;

public class ActivationResponse {
    private String productId;
    private boolean active;

    public ActivationResponse(String productId, boolean active) {
        this.productId = productId;
        this.active = active;
    }

    @Override
    public String toString() {
        return "ActivationResponse{" +
                "productId='" + productId + '\'' +
                ", active=" + active +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
