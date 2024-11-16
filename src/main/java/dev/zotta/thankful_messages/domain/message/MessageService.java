package dev.zotta.thankful_messages.domain.message;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    return message.orElseThrow();
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
}
