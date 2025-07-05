package com.amit.gamelobby.adapter.persistence.mapper;

import com.amit.gamelobby.adapter.persistence.entity.ChatMessageEntity;
import com.amit.gamelobby.domain.model.ChatMessage;

public class ChatMessageMapper {

    public static ChatMessage toDomain(ChatMessageEntity entity) {
        ChatMessage chatMessage = new ChatMessage(
            entity.getLobbyId(),
            entity.getSender(),
            entity.getMessage(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );

        return chatMessage;
    }

    public static ChatMessageEntity toEntity(ChatMessage domain) {
        ChatMessageEntity entity = new ChatMessageEntity();

        entity.setLobbyId(domain.getLobbyId());
        entity.setSender(domain.getSender());
        entity.setMessage(domain.getMessage());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        return entity;
    }
}
