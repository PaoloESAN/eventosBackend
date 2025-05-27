package com.eventofix.eventoback.controller;

import com.eventofix.eventoback.entitys.Locacion;
import com.eventofix.eventoback.services.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locaciones")
public class LocacionController {

    @Autowired
    private LocacionService locacionService;

    @PostMapping("/crear")
    public ResponseEntity<Locacion> crearLocacion(@RequestBody Locacion locacion) {
        return new ResponseEntity<>(locacionService.crearLocacion(locacion), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Locacion> obtenerLocacion(@PathVariable Long id) {
        return ResponseEntity.ok(locacionService.obtenerLocacion(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Locacion>> listarLocaciones() {
        return ResponseEntity.ok(locacionService.listarLocaciones());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Locacion> actualizarLocacion(@PathVariable Long id, @RequestBody Locacion locacion) {
        locacion.setLocacionId(id);
        return ResponseEntity.ok(locacionService.actualizarLocacion(locacion));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLocacion(@PathVariable Long id) {
        locacionService.eliminarLocacion(id);
        return ResponseEntity.noContent().build();
    }
}
