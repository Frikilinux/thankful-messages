package dev.zotta.thankful_messages.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.zotta.thankful_messages.dto.MessageCreateDto;
import dev.zotta.thankful_messages.model.Message;
import dev.zotta.thankful_messages.repository.MessageRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MessageService {

  @Autowired
  private MessageRepository messageRepository;

  @Transactional
  public Message createMessage(MessageCreateDto messageCreateDto) {
    Message message = new Message(messageCreateDto);
    messageRepository.save(message);
    return message;
  }

  public Message getMessageById(Long id) {
    Optional<Message> message = messageRepository.findById(id);
    return message.orElseThrow(() -> new EntityNotFoundException("Mensaje no encontrado"));
  }

  public Page<Message> getMessages(Pageable pageable) {
    Page<Message> messages = messageRepository.findAll(pageable);
    return messages;
  }

  @Transactional
  public Message upVoteMessage(Long id) {
    Message message = getMessageById(id);
    message.upVote(message);

    return message;
  }

  @Transactional
  public Message downVoteMessage(Long id) {
    Message message = getMessageById(id);
    message.downVote(message);

    return message;
  }

  public void deleteMessage(Long id) {
    Optional<Message> message = messageRepository.findById(id);
    if (message.isEmpty()) {
      throw new EntityNotFoundException("Mensaje no encontrado");
    }
    messageRepository.deleteById(id);
  }
}
