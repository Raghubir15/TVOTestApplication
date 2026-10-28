package com.tvo.activationservice.controller;

import com.tvo.activationservice.dto.ActivationResponse;
import com.tvo.activationservice.service.ActivationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/activations")
public class ActivationController {

    private final ActivationService service;

    public ActivationController(
            ActivationService service) {

        this.service = service;
    }

    @GetMapping("/{productId}")
    public ActivationResponse getActivation(

            @PathVariable
            String productId) {

        return service.getActivation(productId);
    }
}
