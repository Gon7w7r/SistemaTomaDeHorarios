package com.sistema.sistematomahorarios.controllers;

import com.sistema.sistematomahorarios.dto.PreferenciaAlumnoRequestDTO;
import com.sistema.sistematomahorarios.entities.PreferenciaAlumno;
import com.sistema.sistematomahorarios.enums.TipoUsuario;
import com.sistema.sistematomahorarios.security.RolRequerido;
import com.sistema.sistematomahorarios.services.PreferenciaAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preferencias")
public class PreferenciaAlumnoController {

    @Autowired
    private PreferenciaAlumnoService preferenciaAlumnoService;

    @PutMapping("/alumno/{idAlumno}")
    @RolRequerido({ TipoUsuario.ALUMNO, TipoUsuario.ADMINISTRATIVO })
    public PreferenciaAlumno guardarPreferencia(
            @PathVariable Integer idAlumno,
            @RequestBody PreferenciaAlumnoRequestDTO request) {
        return preferenciaAlumnoService.guardarPreferencia(idAlumno, request);
    }

    @GetMapping("/alumno/{idAlumno}/{idPeriodo}")
    @RolRequerido({ TipoUsuario.ALUMNO, TipoUsuario.ADMINISTRATIVO })
    public ResponseEntity<PreferenciaAlumno> obtenerPreferencia(
            @PathVariable Integer idAlumno,
            @PathVariable Integer idPeriodo) {
        return preferenciaAlumnoService.obtenerPreferencia(idAlumno, idPeriodo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/periodo/{idPeriodo}")
    @RolRequerido({ TipoUsuario.ADMINISTRATIVO })
    public List<PreferenciaAlumno> obtenerPreferenciasPorPeriodo(
            @PathVariable Integer idPeriodo) {
        return preferenciaAlumnoService.obtenerPreferenciasPorPeriodo(idPeriodo);
    }
}