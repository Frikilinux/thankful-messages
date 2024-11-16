package dev.zotta.thankful_messages.exception.dto;

import org.springframework.http.HttpStatus;

public record ExceptionResponseDto(HttpStatus status, String message) {
}
