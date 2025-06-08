package com.eventofix.eventoback.repository;

import com.eventofix.eventoback.entitys.AsistenteEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsistenteEventoRepository extends JpaRepository<AsistenteEvento, Long> {
    List<AsistenteEvento> findByEventoId(Long eventoId);

    List<AsistenteEvento> findByUsuarioId(Long usuarioId);

    List<AsistenteEvento> findByTicketId(Long ticketId);
}
