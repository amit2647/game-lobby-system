// src/main/java/com/amit/gamelobby/dto/CreateLobbyRequest.java
package com.amit.gamelobby.dto;

public class CreatePlayer {

    private String playerName;
    private String email;
    private String password;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
