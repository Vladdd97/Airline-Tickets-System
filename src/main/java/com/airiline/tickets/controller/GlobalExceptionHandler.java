package com.airiline.tickets.controller;

import com.airiline.tickets.dto.error.ErrorResponse;
import com.airiline.tickets.dto.error.ValidationError;
import com.airiline.tickets.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String VALIDATION_FAILED_MESSAGE = "Validation Failed";

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleExceptions(MethodArgumentNotValidException ex) {
        List<ValidationError> validationError = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> new ValidationError(e.getField(), e.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(createErrorResponse(VALIDATION_FAILED_MESSAGE, validationError));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleExceptions(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(ex.getMessage()));
    }

    private ErrorResponse createErrorResponse(String message) {
        return createErrorResponse(message, null);
    }

    private ErrorResponse createErrorResponse(String message, List<ValidationError> validationErrors) {
        return new ErrorResponse(message, validationErrors);
    }
}
