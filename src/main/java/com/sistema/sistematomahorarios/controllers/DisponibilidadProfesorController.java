package com.sistema.sistematomahorarios.controllers;

import com.sistema.sistematomahorarios.dto.DisponibilidadProfesorRequestDTO;
import com.sistema.sistematomahorarios.entities.DisponibilidadProfesor;
import com.sistema.sistematomahorarios.enums.TipoUsuario;
import com.sistema.sistematomahorarios.security.RolRequerido;
import com.sistema.sistematomahorarios.services.DisponibilidadProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidad-profesor")
public class DisponibilidadProfesorController {

    @Autowired
    private DisponibilidadProfesorService disponibilidadProfesorService;

    @PutMapping("/{idProfesor}")
    @RolRequerido({ TipoUsuario.PROFESOR, TipoUsuario.ADMINISTRATIVO })
    public String guardarDisponibilidad(
            @PathVariable Integer idProfesor,
            @RequestBody DisponibilidadProfesorRequestDTO request) {
        return disponibilidadProfesorService.guardarDisponibilidad(idProfesor, request);
    }

    @GetMapping("/{idProfesor}/{idPeriodo}")
    @RolRequerido({ TipoUsuario.PROFESOR, TipoUsuario.ADMINISTRATIVO })
    public List<DisponibilidadProfesor> obtenerDisponibilidad(
            @PathVariable Integer idProfesor,
            @PathVariable Integer idPeriodo) {
        return disponibilidadProfesorService.obtenerDisponibilidad(idProfesor, idPeriodo);
    }

    @GetMapping("/periodo/{idPeriodo}")
    @RolRequerido({ TipoUsuario.ADMINISTRATIVO })
    public List<DisponibilidadProfesor> obtenerDisponibilidadPorPeriodo(
            @PathVariable Integer idPeriodo) {
        return disponibilidadProfesorService.obtenerDisponibilidadPorPeriodo(idPeriodo);
    }
}