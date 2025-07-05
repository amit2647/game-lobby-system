package com.amit.gamelobby.adapter.persistence.repository.chatmessagerepository;

import com.amit.gamelobby.adapter.persistence.entity.ChatMessageEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataChatMessageRepository
    extends JpaRepository<ChatMessageEntity, UUID> {
    // add custom queries
}
