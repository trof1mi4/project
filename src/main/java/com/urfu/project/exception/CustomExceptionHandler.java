package com.urfu.project.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_GATEWAY.value());
        error.setMessage("Custom 502 Error: " + ex.getMessage());
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(error);
    }

    @Data
    private static class ErrorResponse {
        private int status;
        private String message;
        private LocalDateTime timestamp;
    }
}
