package com.tvo.activationservice.service;

import com.tvo.activationservice.dto.ActivationResponse;
import com.tvo.activationservice.exception.ActivationNotFoundException;
import com.tvo.activationservice.repository.ActivationRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivationService {

    private final ActivationRepository repository;

    public ActivationService(
            ActivationRepository repository) {

        this.repository = repository;
    }

    public ActivationResponse getActivation(
            String productId) {

        return repository.findByProductId(productId)
                .map(activation ->
                        new ActivationResponse(
                                activation.getProductId(),
                                activation.getStatus()))
                .orElseThrow(() ->
                        new ActivationNotFoundException(
                                productId));
    }
}
