package com.amit.gamelobby.application.port.out;

import com.amit.gamelobby.domain.model.ChatMessage;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatMessageRepositoryPort {
    ChatMessage save(ChatMessage chatMassage);
    Optional<ChatMessage> findById(UUID id);
    List<ChatMessage> findAll();
    void deleteById(UUID id);
}
