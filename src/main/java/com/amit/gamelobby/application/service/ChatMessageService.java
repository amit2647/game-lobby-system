package com.amit.gamelobby.application.service;

import com.amit.gamelobby.application.port.in.ChatMessageUseCase;
import com.amit.gamelobby.application.port.out.ChatMessageRepositoryPort;
import com.amit.gamelobby.domain.model.ChatMessage;

public class ChatMessageService implements ChatMessageUseCase {

    private final ChatMessageRepositoryPort chatMessageRepositoryPort;

    public ChatMessageService(
        ChatMessageRepositoryPort chatMessageRepositoryPort
    ) {
        this.chatMessageRepositoryPort = chatMessageRepositoryPort;
    }

    @Override
    public ChatMessage sendChatMessage(ChatMessage chatMessage) {
        return chatMessageRepositoryPort.save(chatMessage);
    }
}
