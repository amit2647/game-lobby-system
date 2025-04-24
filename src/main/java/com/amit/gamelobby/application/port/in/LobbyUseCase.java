package com.amit.gamelobby.application.port.in;

import com.amit.gamelobby.domain.model.Lobby;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LobbyUseCase {
    Lobby createLobby(String name, int maxPlayers);

    Optional<Lobby> joinLobby(UUID lobbyId, UUID player);

    Optional<Lobby> leaveLobby(UUID lobbyId, UUID player);

    List<Lobby> getAllLobbies();

    Optional<Lobby> getLobbyById(UUID lobbyId);

    void deleteById(UUID lobbyId);
}
