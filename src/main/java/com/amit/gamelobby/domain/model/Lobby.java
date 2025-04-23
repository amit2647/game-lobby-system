package com.amit.gamelobby.domain.model;

import com.amit.gamelobby.domain.exception.EmptyLobbyException;
import com.amit.gamelobby.domain.exception.LobbyFullException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lobby {

    private final UUID lobbyId;
    private String name;
    private int maxPlayers;
    private final List<Player> players = new ArrayList<>();
    private boolean gameStarted;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    // Use this constructor for creating new lobbies (Hibernate generates UUID)
    public Lobby(String name, int maxPlayers) {
        this(null, name, maxPlayers);
    }

    // Full constructor used when loading from DB or mapping
    public Lobby(UUID lobbyId, String name, int maxPlayers) {
        System.out.println("Lobby constructor creating object");
        this.lobbyId = lobbyId;
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = ZonedDateTime.now();
    }

    // Getters...

    public UUID getLobbyId() {
        return lobbyId;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Behavior...
    public void addPlayer(Player player) {
        if (players.size() >= maxPlayers) {
            throw new LobbyFullException("Lobby is full.");
        }
        players.add(player);
        updatedAt = ZonedDateTime.now();
    }

    public void removePlayer(Player player) {
        players.removeIf(p -> p.getId().equals(player.getId()));
        updatedAt = ZonedDateTime.now();
    }

    public void startGame() {
        if (players.isEmpty()) {
            throw new EmptyLobbyException("Cannot start game with no players.");
        }
        gameStarted = true;
        updatedAt = ZonedDateTime.now();
    }
}
