package com.tvo.activationservice;

import com.tvo.activationservice.dto.ActivationResponse;
import com.tvo.activationservice.exception.ActivationNotFoundException;
import com.tvo.activationservice.model.Activation;
import com.tvo.activationservice.repository.ActivationRepository;
import com.tvo.activationservice.service.ActivationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
class ActivationServiceTest {

    @Mock
    private ActivationRepository repository;

    @InjectMocks
    private ActivationService service;

    @Test
    void shouldReturnActivation() {

        when(repository.findByProductId("P100"))
                .thenReturn(
                        Optional.of(
                                new Activation(
                                        "P100",
                                        true
                                )
                        ));

        ActivationResponse response =
                service.getActivation("P100");

        assertTrue(response.getProductId(),response.isActive());
        assertEquals(
                "P100",
                response.getProductId(),response.isActive());
    }

    @Test
    void shouldThrowNotFoundException() {

        when(repository.findByProductId("P999"))
                .thenReturn(Optional.empty());

        assertThrows(
                ActivationNotFoundException.class,
                () -> service.getActivation("P999"));
    }
}
