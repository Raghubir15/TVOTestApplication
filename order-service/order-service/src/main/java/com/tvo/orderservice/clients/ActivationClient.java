package com.tvo.orderservice.clients;

import com.tvo.orderservice.dto.ActivationDto;
import com.tvo.orderservice.exception.ExternalServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ActivationClient {

    private final RestClient restClient;

    @Value("${services.activation.url}")
    private String activationUrl;

    public ActivationClient(RestClient restClient) {

        this.restClient = restClient;
    }

    public ActivationDto getActivation(String productId) {

        return restClient.get().uri(activationUrl + "/activations/{id}",
                productId).retrieve().onStatus(HttpStatusCode::isError, (req, res) -> {
            throw new ExternalServiceException("Activation Service Error");
        }).body(ActivationDto.class);
    }
}
