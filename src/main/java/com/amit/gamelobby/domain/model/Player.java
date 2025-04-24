package com.amit.gamelobby.domain.model;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class Player {

    private final UUID playerId;
    private String playerName;
    private String email;
    private String password;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Player(UUID playerId) {
        this.playerId = playerId;
    }

    public Player(String playerName, String email, String password) {
        this.playerId = null;
        this.playerName = playerName;
        this.email = email;
        this.password = password;
    }

    public Player(
        UUID playerId,
        String playerName,
        String email,
        String password
    ) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.email = email;
        this.password = password;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = ZonedDateTime.now();
    }

    public UUID getId() {
        return playerId;
    }

    public UUID getPlayerId() {
        return playerId;
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

    // Use for comparisons in removePlayer
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(playerId, player.playerId);
    }

    @Override
    public String toString() {
        return (
            "Player{" +
            "playerId=" +
            playerId +
            ", playerName='" +
            playerName +
            '\'' +
            ", email='" +
            email +
            '\'' +
            ", createdAt=" +
            createdAt +
            ", updatedAt=" +
            updatedAt +
            '}'
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }
}
