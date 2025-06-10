package com.eventofix.eventoback.controller;

import com.eventofix.eventoback.entitys.Evento;
import com.eventofix.eventoback.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/crear")
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        return new ResponseEntity<>(eventoService.crearEvento(evento), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Evento> obtenerEvento(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.obtenerEvento(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Evento>> listarEventos() {
        return ResponseEntity.ok(eventoService.listarEventos());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setEventoId(id);
        return ResponseEntity.ok(eventoService.actualizarEvento(evento));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/organizador/{organizadorId}")
    public ResponseEntity<List<Evento>> obtenerEventosPorOrganizador(@PathVariable Long organizadorId) {
        return ResponseEntity.ok(eventoService.obtenerEventosPorOrganizador(organizadorId));
    }

    @GetMapping("/excepto-organizador/{organizadorId}")
    public ResponseEntity<List<Evento>> obtenerEventosExceptoOrganizador(@PathVariable Long organizadorId) {
        return ResponseEntity.ok(eventoService.obtenerEventosExceptoOrganizador(organizadorId));
    }
}
