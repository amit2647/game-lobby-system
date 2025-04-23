package com.amit.gamelobby.application.service;

import com.amit.gamelobby.application.port.in.PlayerUseCase;
import com.amit.gamelobby.application.port.out.PlayerRepositoryPort;
import com.amit.gamelobby.domain.model.Player;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements PlayerUseCase {

    private final PlayerRepositoryPort PlayerRepository;

    public PlayerService(PlayerRepositoryPort PlayerRepository) {
        this.PlayerRepository = PlayerRepository;
    }

    @Override
    public Player createPlayer(
        String playerName,
        String email,
        String password
    ) {
        Player Player = new Player(playerName, email, password);
        return PlayerRepository.save(Player);
    }

    @Override
    public Optional<Player> getPlayerById(UUID id) {
        return PlayerRepository.findbyid(id);
    }

    @Override
    public List<Player> getAllLobbies() {
        return PlayerRepository.findAll();
    }
}
