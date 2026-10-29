package com.tvo.activationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivationResponse {

    private String productId;
    private String status;
}

    /*public ActivationResponse(String productId, String status) {
        this.productId = productId;
        this.status = status ;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ActivationResponse{" +
                "productId='" + productId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}*/