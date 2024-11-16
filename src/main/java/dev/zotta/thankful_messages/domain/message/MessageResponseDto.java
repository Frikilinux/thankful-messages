package dev.zotta.thankful_messages.domain.message;

public record MessageResponseDto(
    Long id,
    String message,
    String author,
    String createdAt,
    int popularity) {

  public MessageResponseDto(Message message) {
    this(message.getId(), message.getMessage(), message.getAuthor(), message.getCreatedAt(), message.getPopularity());
  }

}
