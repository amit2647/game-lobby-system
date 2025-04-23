package com.amit.gamelobby.dto;

import com.amit.gamelobby.domain.model.Lobby;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LobbyResponse {

    private UUID lobbyId;
    private String name;
    private int maxPlayers;
    private List<UUID> players;
    private boolean gameStarted;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public static LobbyResponse fromDomain(Lobby lobby) {
        LobbyResponse dto = new LobbyResponse();
        dto.lobbyId = lobby.getLobbyId();
        dto.name = lobby.getName();
        dto.maxPlayers = lobby.getMaxPlayers();
        dto.players = lobby
            .getPlayers()
            .stream()
            .map(player -> player.getId())
            .collect(Collectors.toList());
        dto.gameStarted = lobby.isGameStarted();
        dto.createdAt = lobby.getCreatedAt();
        dto.updatedAt = lobby.getUpdatedAt();
        return dto;
    }

    public UUID getLobbyId() {
        return lobbyId;
    }

    public void setLobbyId(UUID lobbyId) {
        this.lobbyId = lobbyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public void setPlayers(List<UUID> players) {
        this.players = players;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
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
    // Getters and setters (optional for frameworks like Jackson)

}
