package dev.zotta.thankful_messages.domain.message;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "message")
@Entity(name = "Message")
@Getter
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;
  private String author;
  private String createdAt;
  private int popularity = 0;

  public Message(MessageCreateDto messageCreateDto) {
    this.message = messageCreateDto.message();
    this.author = messageCreateDto.author();
    this.createdAt = java.time.LocalDateTime.now().toString();
  }
  
  public void setPopularity(int popularity) {
    this.popularity = popularity + 1;
  }

}
