package com.amit.gamelobby.adapter.persistence.repository.playerrepository;

import com.amit.gamelobby.adapter.persistence.entity.PlayerEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPlayerRepository
    extends JpaRepository<PlayerEntity, UUID> {
    // add custom queries if you want
}
