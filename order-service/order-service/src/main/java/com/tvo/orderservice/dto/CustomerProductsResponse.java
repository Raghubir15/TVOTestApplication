package com.tvo.orderservice.dto;

import java.util.List;
public class CustomerProductsResponse {
   private  String customerId;
    private Integer totalProducts;
    private List<CustomerProductDto> products;

    public CustomerProductsResponse(String customerId, List<CustomerProductDto> result) {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public List<CustomerProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<CustomerProductDto> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CustomerProductsResponse{" +
                "customerId='" + customerId + '\'' +
                ", totalProducts=" + totalProducts +
                ", products=" + products +
                '}';
    }
}
