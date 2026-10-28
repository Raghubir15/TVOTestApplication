package com.tvo.productservice.controller;

import com.tvo.productservice.dto.ProductResponse;
import com.tvo.productservice.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(
            ProductService service) {
        this.service = service;
    }

    @GetMapping("/customer/{customerId}")
    public List<ProductResponse> getProducts(
            @PathVariable
            String customerId) {
        return service.getProducts(customerId);
    }
}
