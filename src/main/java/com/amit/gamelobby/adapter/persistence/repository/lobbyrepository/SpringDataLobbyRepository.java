package com.amit.gamelobby.adapter.persistence.repository.lobbyrepository;

import com.amit.gamelobby.adapter.persistence.entity.LobbyEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataLobbyRepository
    extends JpaRepository<LobbyEntity, UUID> {
    // You can add custom queries here if needed
}
