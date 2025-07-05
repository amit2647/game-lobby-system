package com.amit.gamelobby.application.port.in;

import com.amit.gamelobby.domain.model.ChatMessage;

public interface ChatMessageUseCase {
    ChatMessage sendChatMessage(ChatMessage chatMessage);
}
