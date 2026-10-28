package com.tvo.productservice.Exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    LocalDateTime timestamp;
    int status;
    String message;
    List<String> errors;

    public ErrorResponse(LocalDateTime now, int i, String message, List<Object> of) {
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
