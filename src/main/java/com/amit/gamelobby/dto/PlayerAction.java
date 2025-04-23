// src/main/java/com/amit/gamelobby/dto/PlayerActionRequest.java
package com.amit.gamelobby.dto;

import java.util.UUID;

public class PlayerAction {

    private UUID player;

    public UUID getPlayer() {
        return player;
    }

    public void setPlayer(UUID player) {
        this.player = player;
    }
}
