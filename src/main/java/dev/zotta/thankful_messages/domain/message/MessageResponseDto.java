package dev.zotta.thankful_messages.domain.message;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
