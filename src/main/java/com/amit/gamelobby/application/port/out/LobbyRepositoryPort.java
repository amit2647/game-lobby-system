package com.amit.gamelobby.application.port.out;

import com.amit.gamelobby.domain.model.Lobby;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LobbyRepositoryPort {
    Lobby save(Lobby lobby);
    Optional<Lobby> findById(UUID id);
    List<Lobby> findAll();
    void deleteById(UUID id);
}
