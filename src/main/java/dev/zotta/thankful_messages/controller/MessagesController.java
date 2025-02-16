package dev.zotta.thankful_messages.controller;

import java.net.URI;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.zotta.thankful_messages.dto.MessageCreateDto;
import dev.zotta.thankful_messages.dto.MessageResponseDto;
import dev.zotta.thankful_messages.model.Message;
import dev.zotta.thankful_messages.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Messages", description = "API de mensajes de agradecimiento")
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/messages")
public class MessagesController {

  @Autowired
  private MessageService messageService;

  @Operation(summary = "Crea un mensaje")
  @PostMapping
  public ResponseEntity<MessageResponseDto> createMessage(@RequestBody @Valid MessageCreateDto messageCreateDto,
      UriComponentsBuilder uriComponentsBuilder) {
    Message newMessage = messageService.createMessage(messageCreateDto);
    URI uri = uriComponentsBuilder.path("/messages/{id}").buildAndExpand(newMessage.getId()).toUri();
    return ResponseEntity.created(uri).body(new MessageResponseDto(newMessage));

  }

  @Operation(summary = "Obtiene un mensaje por id")
  @GetMapping("/{id}")
  public ResponseEntity<MessageResponseDto> getMessageById(@PathVariable Long id) {
    Message message = messageService.getMessageById(id);
    return ResponseEntity.ok(new MessageResponseDto(message));
  }

  @Operation(summary = "Obtiene todos los mensajes")
  @GetMapping
  public ResponseEntity<Page<MessageResponseDto>> getMessages(
      @PageableDefault(size = 20, sort = "id") @ParameterObject Pageable pageable) {
    Page<Message> messages = messageService.getMessages(pageable);
    return ResponseEntity.ok(messages.map(MessageResponseDto::new));
  }

  @Operation(summary = "Sube el voto de un mensaje")
  @PutMapping("/{id}/upvote")
  public ResponseEntity<MessageResponseDto> upVoteMessage(@PathVariable Long id) {
    Message message = messageService.upVoteMessage(id);
    return ResponseEntity.ok(new MessageResponseDto(message));
  }

  @Operation(summary = "Baja el voto de un mensaje")
  @PutMapping("/{id}/downvote")
  public ResponseEntity<MessageResponseDto> downVoteMessage(@PathVariable Long id) {
    Message message = messageService.downVoteMessage(id);
    return ResponseEntity.ok(new MessageResponseDto(message));
  }

  @Operation(summary = "Elimina un mensaje")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteMessage(@PathVariable Long id) {
    messageService.deleteMessage(id);
    return ResponseEntity.ok("Mensaje borrado");
  }

}
