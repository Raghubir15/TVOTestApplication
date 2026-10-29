
package com.tvo.activationservice.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ActivationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ActivationNotFoundException ex) {

        return ResponseEntity.status(404)
                .body(
                        new ErrorResponse(
                                LocalDateTime.now(),
                                404,
                                ex.getMessage(),
                                List.of()
                        ));
    }

    @ExceptionHandler(
            ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            ConstraintViolationException ex) {

        return ResponseEntity.badRequest()
                .body(
                        new ErrorResponse(
                                LocalDateTime.now(),
                                400,
                                "Validation Failed",
                                List.of(ex.getMessage())
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

