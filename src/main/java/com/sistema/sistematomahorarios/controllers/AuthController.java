package com.sistema.sistematomahorarios.controllers;

import com.sistema.sistematomahorarios.entities.Usuario;
import com.sistema.sistematomahorarios.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String rut,
            @RequestParam String password
    ) {
        Usuario usuario = authService.login(rut, password);

        if (usuario == null) {
            return ResponseEntity.status(401).body("RUT o contraseña incorrectos");
        }

        return ResponseEntity.ok(usuario);
    }

}
