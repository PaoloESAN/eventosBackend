package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Locacion;
import com.eventofix.eventoback.repository.LocacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacionServiceImpl implements LocacionService {

    @Autowired
    private LocacionRepository locacionRepository;

    @Override
    public Locacion crearLocacion(Locacion locacion) {
        return locacionRepository.save(locacion);
    }

    @Override
    public Locacion obtenerLocacion(Long id) {
        return locacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locacion no encontrada"));
    }

    @Override
    public List<Locacion> listarLocaciones() {
        return locacionRepository.findAll();
    }

    @Override
    public Locacion actualizarLocacion(Locacion locacion) {
        return locacionRepository.save(locacion);
    }

    @Override
    public void eliminarLocacion(Long id) {
        locacionRepository.deleteById(id);
    }
}