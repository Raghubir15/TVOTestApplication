package com.tvo.productservice.model;

import java.util.Objects;

public class Product {
   private String customerId;
   private String productId;
   private String productName;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "Product{" +
                "customerId='" + customerId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(customerId, product.customerId) && Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, productId, productName);
    }

    public Product(String customerId, String productId, String productName) {
        this.customerId = customerId;
        this.productId = productId;
        this.productName = productName;
    }
}
