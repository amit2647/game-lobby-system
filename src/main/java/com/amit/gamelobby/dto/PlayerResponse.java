package com.amit.gamelobby.dto;

import com.amit.gamelobby.domain.model.Player;
import java.time.ZonedDateTime;
import java.util.UUID;

public class PlayerResponse {

    private UUID playerId;
    private String playerName;
    private String email;
    private String password;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public static PlayerResponse fromDomain(Player entity) {
        PlayerResponse Player = new PlayerResponse();
        Player.playerId = entity.getPlayerId();
        Player.playerName = entity.getPlayerName();
        Player.email = entity.getEmail();
        Player.password = entity.getPassword();
        Player.createdAt = entity.getCreatedAt();
        Player.updatedAt = entity.getUpdatedAt();
        return Player;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
