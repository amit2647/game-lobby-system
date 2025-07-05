package com.amit.gamelobby.domain.model;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ChatMessage {

    private UUID lobbyId;
    private String sender;
    private String message;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public ChatMessage(
        UUID lobbyId,
        String sender,
        String message,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt
    ) {
        this.lobbyId = lobbyId;
        this.sender = sender;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
