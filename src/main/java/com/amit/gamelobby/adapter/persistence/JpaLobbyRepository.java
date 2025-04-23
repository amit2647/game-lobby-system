package com.amit.gamelobby.adapter.persistence;

import com.amit.gamelobby.adapter.persistence.entity.LobbyEntity;
import com.amit.gamelobby.adapter.persistence.mapper.LobbyMapper;
import com.amit.gamelobby.application.port.out.LobbyRepositoryPort;
import com.amit.gamelobby.domain.model.Lobby;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class JpaLobbyRepository implements LobbyRepositoryPort {

    private final SpringDataLobbyRepository repository;

    public JpaLobbyRepository(SpringDataLobbyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lobby save(Lobby lobby) {
        System.out.println("Enter the Jpa Lobby Repository save");
        LobbyEntity entity = LobbyMapper.toEntity(lobby);
        LobbyEntity saved = repository.save(entity);
        return LobbyMapper.toDomain(saved);
    }

    @Override
    public Optional<Lobby> findById(UUID id) {
        return repository.findById(id).map(LobbyMapper::toDomain);
    }

    @Override
    public List<Lobby> findAll() {
        return repository
            .findAll()
            .stream()
            .map(LobbyMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
