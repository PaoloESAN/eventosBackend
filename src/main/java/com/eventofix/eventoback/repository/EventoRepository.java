package com.eventofix.eventoback.repository;

import com.eventofix.eventoback.entitys.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByOrganizadorId(Long organizadorId);

}
