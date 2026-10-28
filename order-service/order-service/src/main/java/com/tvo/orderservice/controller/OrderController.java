package com.tvo.orderservice.controller;

import com.tvo.orderservice.dto.CustomerProductsResponse;
import com.tvo.orderservice.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(
            OrderService service) {

        this.service = service;
    }

    @GetMapping("/customer/{customerId}/products")
    public CustomerProductsResponse getProducts(@PathVariable
                                                String customerId) {

        return service.getProducts(customerId);
    }
}
