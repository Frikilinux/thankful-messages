package dev.zotta.thankful_messages.exception.dto;

import org.springframework.validation.FieldError;

public record ValidationResponseDto(String field, String message) {
  public ValidationResponseDto(FieldError fieldError) {
    this(fieldError.getField(), fieldError.getDefaultMessage());
  }
}
