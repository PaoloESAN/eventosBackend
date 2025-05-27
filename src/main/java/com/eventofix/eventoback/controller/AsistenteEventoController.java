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

    @GetMapping("/buscar/{eventoId}/{usuarioId}")
    public ResponseEntity<AsistenteEvento> obtenerAsistenteEvento(@PathVariable Long eventoId,
            @PathVariable Long usuarioId) {
        AsistenteEvento.AsistenteEventoId id = new AsistenteEvento.AsistenteEventoId();
        id.setEventoId(eventoId);
        id.setUsuarioId(usuarioId);
        return ResponseEntity.ok(asistenteEventoService.obtenerAsistenteEvento(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AsistenteEvento>> listarAsistentesEvento() {
        return ResponseEntity.ok(asistenteEventoService.listarAsistentesEvento());
    }

    @PutMapping("/actualizar/{eventoId}/{usuarioId}")
    public ResponseEntity<AsistenteEvento> actualizarAsistenteEvento(@PathVariable Long eventoId,
            @PathVariable Long usuarioId,
            @RequestBody AsistenteEvento asistenteEvento) {
        AsistenteEvento.AsistenteEventoId id = new AsistenteEvento.AsistenteEventoId();
        id.setEventoId(eventoId);
        id.setUsuarioId(usuarioId);
        asistenteEvento.setId(id);
        return ResponseEntity.ok(asistenteEventoService.actualizarAsistenteEvento(asistenteEvento));
    }

    @DeleteMapping("/eliminar/{eventoId}/{usuarioId}")
    public ResponseEntity<Void> eliminarAsistenteEvento(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        AsistenteEvento.AsistenteEventoId id = new AsistenteEvento.AsistenteEventoId();
        id.setEventoId(eventoId);
        id.setUsuarioId(usuarioId);
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
}
