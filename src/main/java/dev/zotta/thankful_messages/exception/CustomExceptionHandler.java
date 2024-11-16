package dev.zotta.thankful_messages.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import dev.zotta.thankful_messages.exception.dto.ExceptionResponseDto;
import dev.zotta.thankful_messages.exception.dto.ExceptionListReponseDto;
import dev.zotta.thankful_messages.exception.dto.ValidationResponseDto;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleException(Exception ex) {
        return ResponseEntity.status(400)
                .body(new ExceptionResponseDto(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponseDto> badJson(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(400)
                .body(new ExceptionResponseDto(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> resourceNotFoundvalidation(EntityNotFoundException ex) {
        return ResponseEntity.status(404)
                .body(new ExceptionResponseDto(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ExceptionResponseDto> noResourceFoundExceptionValidation(NoResourceFoundException ex) {
        return ResponseEntity.status(404)
                .body(new ExceptionResponseDto(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionListReponseDto> dataValidation(MethodArgumentNotValidException ex) {
    List<ValidationResponseDto> errors = ex.getFieldErrors().stream().map(ValidationResponseDto::new).toList();
    return ResponseEntity.badRequest().body(new ExceptionListReponseDto(HttpStatus.BAD_REQUEST, errors));
  }
}
