package com.tvo.orderservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ExternalServiceException.class)
    public ResponseEntity<ErrorResponse> handleExternal(
            ExternalServiceException ex) {

        return ResponseEntity.status(502)
                .body(
                        new ErrorResponse(
                                LocalDateTime.now(),
                                502,
                                ex.getMessage(),
                                List.of()
                        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception ex) {

        return ResponseEntity.internalServerError()
                .body(
                        new ErrorResponse(
                                LocalDateTime.now(),
                                500,
                                ex.getMessage(),
                                List.of()
                        ));
    }
}