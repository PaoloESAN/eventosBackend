package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.AsistenteEvento;
import java.util.List;

public interface AsistenteEventoService {
    AsistenteEvento crearAsistenteEvento(AsistenteEvento asistenteEvento);

    AsistenteEvento obtenerAsistenteEvento(Long id);

    List<AsistenteEvento> listarAsistentesEvento();

    AsistenteEvento actualizarAsistenteEvento(Long id, AsistenteEvento asistenteEvento);

    void eliminarAsistenteEvento(Long id);

    List<AsistenteEvento> obtenerAsistentesPorEvento(Long eventoId);

    List<AsistenteEvento> obtenerEventosPorUsuario(Long usuarioId);

    List<AsistenteEvento> obtenerAsistentesPorTicket(Long ticketId);
}