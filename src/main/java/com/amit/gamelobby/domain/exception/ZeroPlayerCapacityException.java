package com.amit.gamelobby.domain.exception;

public class ZeroPlayerCapacityException extends IllegalArgumentException {

    private String message;

    public ZeroPlayerCapacityException() {}

    public ZeroPlayerCapacityException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
