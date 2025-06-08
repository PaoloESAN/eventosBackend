package com.eventofix.eventoback.controller;

import com.eventofix.eventoback.entitys.AsistenteEvento;
import com.eventofix.eventoback.services.AsistenteEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asistentes-evento")
public class AsistenteEventoController {

    @Autowired
    private AsistenteEventoService asistenteEventoService;

    @PostMapping("/crear")
    public ResponseEntity<AsistenteEvento> crearAsistenteEvento(@RequestBody AsistenteEvento asistenteEvento) {
        return new ResponseEntity<>(asistenteEventoService.crearAsistenteEvento(asistenteEvento), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<AsistenteEvento> obtenerAsistenteEvento(@PathVariable Long id) {
        return ResponseEntity.ok(asistenteEventoService.obtenerAsistenteEvento(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AsistenteEvento>> listarAsistentesEvento() {
        return ResponseEntity.ok(asistenteEventoService.listarAsistentesEvento());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AsistenteEvento> actualizarAsistenteEvento(
            @PathVariable Long id,
            @RequestBody AsistenteEvento asistenteEvento) {
        return ResponseEntity.ok(asistenteEventoService.actualizarAsistenteEvento(id, asistenteEvento));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAsistenteEvento(@PathVariable Long id) {
        asistenteEventoService.eliminarAsistenteEvento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<AsistenteEvento>> obtenerAsistentesPorEvento(@PathVariable Long eventoId) {
        return ResponseEntity.ok(asistenteEventoService.obtenerAsistentesPorEvento(eventoId));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<AsistenteEvento>> obtenerEventosPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(asistenteEventoService.obtenerEventosPorUsuario(usuarioId));
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<AsistenteEvento>> obtenerAsistentesPorTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(asistenteEventoService.obtenerAsistentesPorTicket(ticketId));
    }
}
