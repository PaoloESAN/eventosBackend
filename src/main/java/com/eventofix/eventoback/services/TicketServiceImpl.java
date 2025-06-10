package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Ticket;
import com.eventofix.eventoback.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket crearTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket obtenerTicket(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    }

    @Override
    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket actualizarTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void eliminarTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> obtenerTicketsPorEvento(Long eventoId) {
        return ticketRepository.findByEventoId(eventoId);
    }

    @Override
    public Ticket actualizarCantidadDisponible(Long id, Integer nuevaCantidad) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        ticket.setCantidadDisponible(nuevaCantidad);
        return ticketRepository.save(ticket);
    }
}
