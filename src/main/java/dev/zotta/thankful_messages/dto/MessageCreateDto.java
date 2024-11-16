package dev.zotta.thankful_messages.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MessageCreateDto(
    @Size(min = 1, max = 250, message = "El mensaje debe tener entre 1 y 250 caracteres") String message,
    @NotBlank(message = "El autor no puede estar vacío") @Size(min = 1, max = 50, message = "El autor debe tener entre 1 y 50 caracteres") String author) {
}
