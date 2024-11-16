package dev.zotta.thankful_messages.contoller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.zotta.thankful_messages.domain.message.Message;
import dev.zotta.thankful_messages.domain.message.MessageCreateDto;
import dev.zotta.thankful_messages.domain.message.MessageResponseDto;
import dev.zotta.thankful_messages.domain.message.MessageService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/messages")
public class MessagesController {

  @Autowired
  private MessageService messageService;

  @PostMapping
  public ResponseEntity<MessageResponseDto> createMessage(@RequestBody MessageCreateDto messageCreateDto,
      UriComponentsBuilder uriComponentsBuilder) {

    Message newMessage = messageService.createMessage(messageCreateDto);

    URI uri = uriComponentsBuilder.path("/messages/{id}").buildAndExpand(newMessage.getId()).toUri();

    return ResponseEntity.created(uri).body(new MessageResponseDto(newMessage));

  }

}
