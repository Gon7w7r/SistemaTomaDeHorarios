package com.sistema.sistematomahorarios.controllers;

import com.sistema.sistematomahorarios.entities.Seccion;
import com.sistema.sistematomahorarios.services.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secciones")
public class SeccionController {

    @Autowired
    private SeccionService seccionService;

    @GetMapping
    public List<Seccion> listarTodas() {
        return seccionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Object buscarPorId(@PathVariable Integer id) {
        return seccionService.buscarPorId(id)
                .<Object>map(s -> s)
                .orElse("Sección no encontrada");
    }

    @GetMapping("/asignatura/{idAsignatura}")
    public List<Seccion> listarPorAsignatura(@PathVariable Integer idAsignatura) {
        return seccionService.listarPorAsignatura(idAsignatura);
    }

    @GetMapping("/profesor/{idProfesor}")
    public List<Seccion> listarPorProfesor(@PathVariable Integer idProfesor) {
        return seccionService.listarPorProfesor(idProfesor);
    }

    @PostMapping
    public Seccion crear(@RequestBody Seccion seccion) {
        return seccionService.crear(seccion);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Integer id, @RequestBody Seccion datos) {
        return seccionService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return seccionService.eliminar(id);
    }
}
