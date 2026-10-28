package com.tvo.productservice.Exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(
            ProductNotFoundException ex) {

        return ResponseEntity.status(404)
                .body(
                        new ErrorResponse(
                                LocalDateTime.now(),
                                404,
                                ex.getMessage(),
                                List.of()
                        )
                );
    }
}