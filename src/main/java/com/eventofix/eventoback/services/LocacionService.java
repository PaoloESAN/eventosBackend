package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Locacion;
import java.util.List;

public interface LocacionService {
    Locacion crearLocacion(Locacion locacion);

    Locacion obtenerLocacion(Long id);

    List<Locacion> listarLocaciones();

    Locacion actualizarLocacion(Locacion locacion);

    void eliminarLocacion(Long id);
}
