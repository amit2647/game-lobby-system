package com.amit.gamelobby.application.port.out;

import com.amit.gamelobby.domain.model.Player;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerRepositoryPort {
    Player save(Player player);
    Optional<Player> findbyid(UUID id);
    List<Player> findAll();
    void deleteById(UUID id);
}
