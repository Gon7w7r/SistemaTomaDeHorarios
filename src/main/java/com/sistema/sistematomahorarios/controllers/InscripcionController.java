package com.sistema.sistematomahorarios.controllers;



import com.sistema.sistematomahorarios.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/inscribir")
    public String inscribir(
            @RequestParam Integer idAlumno,
            @RequestParam Integer idSeccion,
            @RequestParam Integer idPeriodo
    ) {
        return inscripcionService.inscribir(idAlumno, idSeccion, idPeriodo);
    }
}