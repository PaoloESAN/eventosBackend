package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.AsistenteEvento;
import com.eventofix.eventoback.repository.AsistenteEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenteEventoServiceImpl implements AsistenteEventoService {

    @Autowired
    private AsistenteEventoRepository asistenteEventoRepository;

    @Override
    public AsistenteEvento crearAsistenteEvento(AsistenteEvento asistenteEvento) {
        return asistenteEventoRepository.save(asistenteEvento);
    }

    @Override
    public AsistenteEvento obtenerAsistenteEvento(Long id) {
        return asistenteEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistente de evento no encontrado"));
    }

    @Override
    public List<AsistenteEvento> listarAsistentesEvento() {
        return asistenteEventoRepository.findAll();
    }

    @Override
    public AsistenteEvento actualizarAsistenteEvento(Long id, AsistenteEvento asistenteEvento) {
        if (!asistenteEventoRepository.existsById(id)) {
            throw new RuntimeException("Asistente de evento no encontrado");
        }
        asistenteEvento.setAsistenteId(id);
        return asistenteEventoRepository.save(asistenteEvento);
    }

    @Override
    public void eliminarAsistenteEvento(Long id) {
        asistenteEventoRepository.deleteById(id);
    }

    @Override
    public List<AsistenteEvento> obtenerAsistentesPorEvento(Long eventoId) {
        return asistenteEventoRepository.findByEventoId(eventoId);
    }

    @Override
    public List<AsistenteEvento> obtenerEventosPorUsuario(Long usuarioId) {
        return asistenteEventoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<AsistenteEvento> obtenerAsistentesPorTicket(Long ticketId) {
        return asistenteEventoRepository.findByTicketId(ticketId);
    }
}
