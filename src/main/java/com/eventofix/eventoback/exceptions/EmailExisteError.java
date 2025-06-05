package com.eventofix.eventoback.exceptions;

public class EmailExisteError extends RuntimeException {
    public EmailExisteError(String message) {
        super(message);
    }
}
