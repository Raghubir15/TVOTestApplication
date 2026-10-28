package com.tvo.orderservice.dto;


public class CustomerProductDto {
    private String productId;
    private String productName;
    private boolean active;

    public CustomerProductDto(String productId, String productName, boolean active) {
        this.productId = productId;
        this.productName = productName;
        this.active = active;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerProductDto{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", active=" + active +
                '}';
    }
}
