package dev.zotta.thankful_messages.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.zotta.thankful_messages.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
  @Query("SELECT 1 FROM Message m WHERE m.message = :message")
  Optional<Message> checkDuplicate(String message);

}
