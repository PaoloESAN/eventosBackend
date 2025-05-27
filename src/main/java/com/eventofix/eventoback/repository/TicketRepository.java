package com.eventofix.eventoback.repository;

import com.eventofix.eventoback.entitys.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByEventoId(Long eventoId);
}
