package com.sistema.sistematomahorarios.controllers;



import com.sistema.sistematomahorarios.dto.InscripcionRequestDTO;
import com.sistema.sistematomahorarios.entities.Inscripcion;
import com.sistema.sistematomahorarios.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/inscribir")
    public String inscribir(@RequestBody InscripcionRequestDTO request) {

        return inscripcionService.inscribir(
                request.getIdAlumno(),
                request.getIdSeccion(),
                request.getIdPeriodo()
        );
    }


    @GetMapping("/alumno/{idAlumno}")
    public List<Inscripcion> obtenerInscripcionesAlumno(
            @PathVariable Integer idAlumno
    ) {
        return inscripcionService.obtenerPorAlumno(idAlumno);
    }
    
}