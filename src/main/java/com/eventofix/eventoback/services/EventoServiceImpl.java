package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Evento;
import com.eventofix.eventoback.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento obtenerEvento(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
    }

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento actualizarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public List<Evento> obtenerEventosPorOrganizador(Long organizadorId) {
        return eventoRepository.findByOrganizadorId(organizadorId);
    }

    @Override
    public List<Evento> obtenerEventosPorLocacion(Long locacionId) {
        return eventoRepository.findByLocacionId(locacionId);
    }
}
