package dev.zotta.thankful_messages.domain.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  private MessageRepository messageRepository;

  public Message createMessage(MessageCreateDto messageCreateDto) {
    Message message = new Message(messageCreateDto);
    messageRepository.save(message);

    return message;
  }
}
