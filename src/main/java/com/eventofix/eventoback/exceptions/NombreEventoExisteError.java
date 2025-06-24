package com.eventofix.eventoback.exceptions;

public class NombreEventoExisteError extends RuntimeException {
    public NombreEventoExisteError(String message) {
        super(message);
    }
}
