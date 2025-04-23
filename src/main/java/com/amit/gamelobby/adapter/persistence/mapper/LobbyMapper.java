package com.amit.gamelobby.adapter.persistence.mapper;

import com.amit.gamelobby.adapter.persistence.entity.LobbyEntity;
import com.amit.gamelobby.domain.model.Lobby;
import com.amit.gamelobby.domain.model.Player;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LobbyMapper {

    public static Lobby toDomain(LobbyEntity entity) {
        Lobby lobby = new Lobby(
            entity.getLobbyId(),
            entity.getName(),
            entity.getMaxPlayers()
        );

        // Convert String IDs to Player objects
        List<Player> players = entity
            .getPlayers()
            .stream()
            .map(Player::new)
            .collect(Collectors.toList());
        players.forEach(lobby::addPlayer);

        if (entity.isGameStarted()) {
            lobby.startGame(); // assumes domain method flips flag
        }

        return lobby;
    }

    public static LobbyEntity toEntity(Lobby domain) {
        LobbyEntity entity = new LobbyEntity();

        // Only set ID if it's not null (i.e., updating an existing lobby)
        if (domain.getLobbyId() != null) {
            entity.setLobbyId(domain.getLobbyId());
        }

        entity.setName(domain.getName());
        entity.setMaxPlayers(domain.getMaxPlayers());
        entity.setGameStarted(domain.isGameStarted());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        List<UUID> playerIds = domain
            .getPlayers()
            .stream()
            .map(Player::getId)
            .collect(Collectors.toList());
        entity.setPlayers(playerIds);

        return entity;
    }
}
