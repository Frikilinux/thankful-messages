package dev.zotta.thankful_messages.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> resourceNotFoundvalidation(EntityNotFoundException e) {
        return ResponseEntity.status(404)
                .body(new ErrorResponseDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponseDto> noResourceFoundExceptionValidation(NoResourceFoundException e) {
        return ResponseEntity.status(404)
                .body(new ErrorResponseDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }
}
