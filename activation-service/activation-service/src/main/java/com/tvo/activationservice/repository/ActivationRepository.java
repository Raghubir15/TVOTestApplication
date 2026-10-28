package com.tvo.activationservice.repository;

import com.tvo.activationservice.model.Activation;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;


@Repository
public class ActivationRepository {

    private final Map<String, Activation> data =
            Map.of(
                    "P100",
                    new Activation("P100", true),

                    "P200",
                    new Activation("P200", false),

                    "P300",
                    new Activation("P300", true)
            );

    public Optional<Activation> findByProductId(
            String productId) {

        return Optional.ofNullable(
                data.get(productId)
        );
    }
}
