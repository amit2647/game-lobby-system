package com.amit.gamelobby.adapter.persistence.repository.chatmessagerepository;

import com.amit.gamelobby.adapter.persistence.entity.ChatMessageEntity;
import com.amit.gamelobby.adapter.persistence.mapper.ChatMessageMapper;
import com.amit.gamelobby.application.port.out.ChatMessageRepositoryPort;
import com.amit.gamelobby.domain.model.ChatMessage;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class JpaChatMessageRepository implements ChatMessageRepositoryPort {

    private final SpringDataChatMessageRepository chatMessageRepository;

    public JpaChatMessageRepository(
        SpringDataChatMessageRepository chatMessageRepository
    ) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public ChatMessage save(ChatMessage chatMassage) {
        ChatMessageEntity entity = ChatMessageMapper.toEntity(chatMassage);
        ChatMessageEntity saved = chatMessageRepository.save(entity);
        return ChatMessageMapper.toDomain(saved);
    }

    @Override
    public Optional<ChatMessage> findById(UUID id) {
        return chatMessageRepository
            .findById(id)
            .map(ChatMessageMapper::toDomain);
    }

    @Override
    public List<ChatMessage> findAll() {
        return chatMessageRepository
            .findAll()
            .stream()
            .map(ChatMessageMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        chatMessageRepository.deleteById(id);
    }
}
