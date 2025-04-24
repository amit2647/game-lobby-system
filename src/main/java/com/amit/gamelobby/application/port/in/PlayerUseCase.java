package com.amit.gamelobby.application.port.in;

import com.amit.gamelobby.domain.model.Player;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerUseCase {
    Player createPlayer(String playerName, String email, String password);
    List<Player> getAllLobbies();
    Optional<Player> getPlayerById(UUID PlayerId);
    void deleteById(UUID PlayerId);
}
