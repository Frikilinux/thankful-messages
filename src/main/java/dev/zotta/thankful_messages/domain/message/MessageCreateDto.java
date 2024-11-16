package dev.zotta.thankful_messages.domain.message;

import jakarta.validation.constraints.NotBlank;

public record MessageCreateDto(
        @NotBlank String message,
        @NotBlank String author) {
}
