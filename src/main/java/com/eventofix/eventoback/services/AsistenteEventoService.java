package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.AsistenteEvento;
import java.util.List;

public interface AsistenteEventoService {
    AsistenteEvento crearAsistenteEvento(AsistenteEvento asistenteEvento);

    AsistenteEvento obtenerAsistenteEvento(AsistenteEvento.AsistenteEventoId id);

    List<AsistenteEvento> listarAsistentesEvento();

    AsistenteEvento actualizarAsistenteEvento(AsistenteEvento asistenteEvento);

    void eliminarAsistenteEvento(AsistenteEvento.AsistenteEventoId id);

    List<AsistenteEvento> obtenerAsistentesPorEvento(Long eventoId);

    List<AsistenteEvento> obtenerEventosPorUsuario(Long usuarioId);
}