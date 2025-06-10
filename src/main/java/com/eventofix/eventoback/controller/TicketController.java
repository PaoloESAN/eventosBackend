package com.eventofix.eventoback.controller;

import com.eventofix.eventoback.entitys.Ticket;
import com.eventofix.eventoback.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/crear")
    public ResponseEntity<Ticket> crearTicket(@RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.crearTicket(ticket), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Ticket> obtenerTicket(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.obtenerTicket(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Ticket>> listarTickets() {
        return ResponseEntity.ok(ticketService.listarTickets());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ticket> actualizarTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        ticket.setTicketId(id);
        return ResponseEntity.ok(ticketService.actualizarTicket(ticket));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<Ticket>> obtenerTicketsPorEvento(@PathVariable Long eventoId) {
        return ResponseEntity.ok(ticketService.obtenerTicketsPorEvento(eventoId));
    }

    @PutMapping("/actualizar-cantidad/{id}")
    public ResponseEntity<Ticket> actualizarCantidadDisponible(@PathVariable Long id,
            @RequestBody Map<String, Integer> request) {
        Integer nuevaCantidad = request.get("cantidadDisponible");
        Ticket ticket = ticketService.actualizarCantidadDisponible(id, nuevaCantidad);
        return ResponseEntity.ok(ticket);
    }
}
