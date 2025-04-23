package com.amit.gamelobby.adapter.persistence.mapper;

import com.amit.gamelobby.adapter.persistence.entity.PlayerEntity;
import com.amit.gamelobby.domain.model.Player;

public class PlayerMapper {

    public static Player toDomain(PlayerEntity entity) {
        Player Player = new Player(
            entity.getPlayerId(),
            entity.getPlayerName(),
            entity.getEmail(),
            entity.getPassword()
        );
        return Player;
    }

    public static PlayerEntity toEntity(Player domain) {
        PlayerEntity entity = new PlayerEntity();

        // Only set ID if it's not null (i.e., updating an existing Player)
        if (domain.getPlayerId() != null) {
            entity.setPlayerId(domain.getPlayerId());
        }

        entity.setPlayerName(domain.getPlayerName());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());

        return entity;
    }
}
