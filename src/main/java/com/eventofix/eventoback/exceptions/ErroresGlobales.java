package com.eventofix.eventoback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErroresGlobales {
    @ExceptionHandler(EmailExisteError.class)
    public ResponseEntity<Map<String, String>> emailError(EmailExisteError e) {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", e.getMessage());
        response.put("codigo", "EMAIL_DUPLICADO");
        response.put("tipo", "VALIDACION");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NombreEventoExisteError.class)
    public ResponseEntity<Map<String, String>> nombreEventoError(NombreEventoExisteError e) {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", e.getMessage());
        response.put("codigo", "NOMBRE_EVENTO_DUPLICADO");
        response.put("tipo", "VALIDACION");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
