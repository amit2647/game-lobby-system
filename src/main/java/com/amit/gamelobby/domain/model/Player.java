package com.amit.gamelobby.domain.model;

import java.util.Objects;

public class Player {

    private final String id;

    public Player(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    // Use for comparisons in removePlayer
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
