package com.tvo.orderservice.dto;

import lombok.Data;

@Data
public class ActivationDto {
    private String productId;
    private boolean active;
}
