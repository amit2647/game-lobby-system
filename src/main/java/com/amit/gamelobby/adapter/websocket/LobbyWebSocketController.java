package com.amit.gamelobby.adapter.websocket;

import com.amit.gamelobby.dto.ChatMessageDto;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class LobbyWebSocketController {

    @MessageMapping("/lobby/{lobbyId}/chat")
    @SendTo("/topic/lobby/{lobbyId}/chat")
    public ChatMessageDto sendChat(
        @DestinationVariable UUID lobbyId,
        ChatMessageDto message
    ) {
        message.setLobbyId(lobbyId);
        message.setTimestamp(ZonedDateTime.now());
        return message;
    }
    // Optionally add @MessageMapping for lobby lifecycle updates
}
