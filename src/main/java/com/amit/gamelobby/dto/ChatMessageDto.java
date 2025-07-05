package com.amit.gamelobby.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ChatMessageDto {

    private UUID lobbyId;
    private String sender;
    private String message;
    private ZonedDateTime timestamp;

    // Getters and Setters

    public UUID getLobbyId() {
        return lobbyId;
    }

    public void setLobbyId(UUID lobbyId) {
        this.lobbyId = lobbyId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
