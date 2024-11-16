package dev.zotta.thankful_messages.dto;

import jakarta.validation.constraints.NotBlank;

public record MessageCreateDto(
                @NotBlank(message = "El mensaje no puede estar vacío") String message,
                @NotBlank(message = "El autor no puede estar vacío") String author) {
}
