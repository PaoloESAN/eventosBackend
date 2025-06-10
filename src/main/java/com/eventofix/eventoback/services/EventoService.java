package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Evento;
import java.util.List;

public interface EventoService {
    Evento crearEvento(Evento evento);

    Evento obtenerEvento(Long id);

    List<Evento> listarEventos();

    Evento actualizarEvento(Evento evento);

    void eliminarEvento(Long id);

    List<Evento> obtenerEventosPorOrganizador(Long organizadorId);

    List<Evento> obtenerEventosExceptoOrganizador(Long organizadorId);
}
