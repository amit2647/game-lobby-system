package com.amit.gamelobby.domain.exception;

public class EmptyLobbyException extends IllegalStateException {

    private String message;

    public EmptyLobbyException() {}

    public EmptyLobbyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
