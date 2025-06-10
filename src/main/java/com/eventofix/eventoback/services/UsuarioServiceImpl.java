package com.eventofix.eventoback.services;

import com.eventofix.eventoback.entitys.Usuario;
import com.eventofix.eventoback.exceptions.EmailExisteError;
import com.eventofix.eventoback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new EmailExisteError("Ese correo ya ha sido usado");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario validarCredenciales(String email, String contrasena) {
        return usuarioRepository.findByEmailAndContrasena(email, contrasena);
    }
}