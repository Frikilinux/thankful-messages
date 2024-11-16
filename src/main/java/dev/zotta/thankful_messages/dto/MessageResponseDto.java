package dev.zotta.thankful_messages.dto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dev.zotta.thankful_messages.model.Message;

public record MessageResponseDto(
    Long id,
    String message,
    String author,
    LocalDateTime createdAt,
    int popularity) {

  public MessageResponseDto(Message message) {
    this(message.getId(), message.getMessage(), message.getAuthor(),
        message.getCreatedAt().truncatedTo(ChronoUnit.SECONDS), message.getPopularity());
  }

}
