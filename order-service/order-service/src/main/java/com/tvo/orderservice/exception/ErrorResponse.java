package com.tvo.orderservice.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class ErrorResponse {
    LocalDateTime timestamp;
    int status;
    String message;
    List<String> errors;

    public ErrorResponse(LocalDateTime timestamp, int status, String message, List<String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
