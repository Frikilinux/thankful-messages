package dev.zotta.thankful_messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.zotta.thankful_messages.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
