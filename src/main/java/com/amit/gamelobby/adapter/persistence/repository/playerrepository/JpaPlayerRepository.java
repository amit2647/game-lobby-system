package com.amit.gamelobby.adapter.persistence.repository.playerrepository;

import com.amit.gamelobby.adapter.persistence.entity.PlayerEntity;
import com.amit.gamelobby.adapter.persistence.mapper.PlayerMapper;
import com.amit.gamelobby.application.port.out.PlayerRepositoryPort;
import com.amit.gamelobby.domain.model.Player;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPlayerRepository implements PlayerRepositoryPort {

    private final SpringDataPlayerRepository repository;

    public JpaPlayerRepository(SpringDataPlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Player save(Player player) {
        PlayerEntity entity = PlayerMapper.toEntity(player);
        PlayerEntity saved = repository.save(entity);
        return PlayerMapper.toDomain(saved);
    }

    @Override
    public Optional<Player> findbyid(UUID id) {
        return repository.findById(id).map(PlayerMapper::toDomain);
    }

    @Override
    public List<Player> findAll() {
        return repository
            .findAll()
            .stream()
            .map(PlayerMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
