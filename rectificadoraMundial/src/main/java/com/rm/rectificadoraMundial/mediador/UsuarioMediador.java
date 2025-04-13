package com.rm.rectificadoraMundial.mediador;

import org.mindrot.jbcrypt.BCrypt;

import com.rm.rectificadoraMundial.modelo.Usuario;
import com.rm.rectificadoraMundial.repositorio.UsuarioRepository;

public class UsuarioMediador {
    private UsuarioRepository usuarioRepo = new UsuarioRepository();

    public Usuario login(String cedula, String contraseña) {
        Usuario usuario = usuarioRepo.obtenerPorCedula(cedula);

        if (usuario != null && BCrypt.checkpw(contraseña, usuario.getContraseña())) {
            // Login exitoso
            return usuario;
        }

        // Login fallido
        return null;
    }

    public String encriptarContraseña(String contraseña) {
        return BCrypt.hashpw(contraseña, BCrypt.gensalt());
    }
}