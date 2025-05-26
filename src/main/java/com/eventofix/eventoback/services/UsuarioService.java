package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuario(Long id);
    List<Usuario> listarUsuarios();
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
}
