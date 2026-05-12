package com.sistema.sistematomahorarios.controllers;

import com.sistema.sistematomahorarios.dto.LoginRequest;
import com.sistema.sistematomahorarios.entities.Usuario;
import com.sistema.sistematomahorarios.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.sistematomahorarios.dto.LoginResponse;
import com.sistema.sistematomahorarios.entities.Alumno;
import com.sistema.sistematomahorarios.repositories.AlumnoRepository;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {


    @Autowired
    private AlumnoRepository alumnoRepository;

    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Usuario usuario = authService.login(
                request.getRut(),
                request.getPassword()
        );

        if (usuario == null) {
            return ResponseEntity.status(401)
                    .body("RUT o contraseña incorrectos");
        }

        Alumno alumno = alumnoRepository.findByUsuarioRut(usuario.getRut());

        LoginResponse response = new LoginResponse(
                alumno.getIdAlumno(),
                usuario.getRut(),
                usuario.getNombre(),
                usuario.getTipoUsuario()
        );

        return ResponseEntity.ok(response);
       }

}
