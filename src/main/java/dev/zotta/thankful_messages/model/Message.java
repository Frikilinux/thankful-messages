package dev.zotta.thankful_messages.model;

import java.time.LocalDateTime;

import dev.zotta.thankful_messages.dto.MessageCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "message")
@Entity(name = "Message")
@Getter
@NoArgsConstructor
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;
  private String author;
  private LocalDateTime createdAt;
  private int popularity = 0;

  public Message(MessageCreateDto messageCreateDto) {
    this.message = messageCreateDto.message();
    this.author = messageCreateDto.author();
    this.createdAt = java.time.LocalDateTime.now();
  }

  public void upVote(Message message) {
    this.popularity = message.getPopularity() + 1;
  }

  public void downVote(Message message) {
    if (message.getPopularity() == 0) {
      return;
    }
    this.popularity = message.getPopularity() - 1;
  }

}