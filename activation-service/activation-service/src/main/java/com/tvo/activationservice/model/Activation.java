package com.tvo.activationservice.model;

public class Activation {
    private String productId;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Activation(String productId, boolean b) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Activation{" +
                "productId='" + productId + '\'' +
                ", active=" + active +
                '}';
    }


}
