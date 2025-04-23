package com.amit.gamelobby.domain.exception;

public class LobbyFullException extends IllegalStateException {

    private String message;

    public LobbyFullException() {}

    public LobbyFullException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
