package com.amit.gamelobby.application.service;

import com.amit.gamelobby.application.port.in.LobbyUseCase;
import com.amit.gamelobby.application.port.out.LobbyRepositoryPort;
import com.amit.gamelobby.domain.exception.ZeroPlayerCapacityException;
import com.amit.gamelobby.domain.model.Lobby;
import com.amit.gamelobby.domain.model.Player;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class LobbyService implements LobbyUseCase {

    private final LobbyRepositoryPort lobbyRepository;

    public LobbyService(LobbyRepositoryPort lobbyRepository) {
        this.lobbyRepository = lobbyRepository;
    }

    @Override
    public Lobby createLobby(String name, int maxPlayers) {
        if (maxPlayers <= 0) {
            throw new ZeroPlayerCapacityException(
                "maxPlayers should be greater than 0"
            );
        }
        System.out.println("Enter the lobby service createLobby");
        Lobby lobby = new Lobby(name, maxPlayers);
        return lobbyRepository.save(lobby);
    }

    @Override
    public Optional<Lobby> joinLobby(UUID lobbyId, String playerId) {
        Optional<Lobby> lobbyOpt = lobbyRepository.findById(lobbyId);
        if (lobbyOpt.isPresent()) {
            Lobby lobby = lobbyOpt.get();
            if (
                !lobby.isGameStarted() &&
                lobby.getPlayers().size() < lobby.getMaxPlayers()
            ) {
                lobby.addPlayer(new Player(playerId));
                return Optional.of(lobbyRepository.save(lobby));
            }
        }
        return lobbyOpt;
    }

    @Override
    public Optional<Lobby> leaveLobby(UUID lobbyId, String playerId) {
        Optional<Lobby> lobbyOpt = lobbyRepository.findById(lobbyId);
        if (lobbyOpt.isPresent()) {
            Lobby lobby = lobbyOpt.get();
            lobby.removePlayer(new Player(playerId));
            return Optional.of(lobbyRepository.save(lobby));
        }
        return lobbyOpt;
    }

    @Override
    public Optional<Lobby> getLobbyById(UUID id) {
        return lobbyRepository.findById(id);
    }

    @Override
    public List<Lobby> getAllLobbies() {
        return lobbyRepository.findAll();
    }
}
