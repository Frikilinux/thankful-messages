package dev.zotta.thankful_messages.errors;

import org.springframework.http.HttpStatus;

public record ErrorResponseDto(HttpStatus status, String message) {
}
