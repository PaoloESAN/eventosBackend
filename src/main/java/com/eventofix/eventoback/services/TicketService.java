package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Ticket;
import java.util.List;

public interface TicketService {
    Ticket crearTicket(Ticket ticket);

    Ticket obtenerTicket(Long id);

    List<Ticket> listarTickets();

    Ticket actualizarTicket(Ticket ticket);

    void eliminarTicket(Long id);

    List<Ticket> obtenerTicketsPorEvento(Long eventoId);

    Ticket actualizarCantidadDisponible(Long id, Integer nuevaCantidad);
}
