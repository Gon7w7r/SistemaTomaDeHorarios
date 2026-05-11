package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.entities.Usuario;
import com.sistema.sistematomahorarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String rut, String password) {

        Usuario usuario = usuarioRepository.findByRut(rut);

        if (usuario == null) {
            return null;
        }

        if (!usuario.getPasswordHash().equals(password)) {
            return null;
        }

        return usuario;
    }

}
