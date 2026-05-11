package com.sistema.sistematomahorarios.controllers;

import com.sistema.sistematomahorarios.entities.Sala;
import com.sistema.sistematomahorarios.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<Sala> listarTodas() {
        return salaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Object buscarPorId(@PathVariable Integer id) {
        return salaService.buscarPorId(id)
                .<Object>map(s -> s)
                .orElse("Sala no encontrada");
    }

    @GetMapping("/sede/{idSede}")
    public List<Sala> listarPorSede(@PathVariable Integer idSede) {
        return salaService.listarPorSede(idSede);
    }

    @PostMapping
    public Sala crear(@RequestBody Sala sala) {
        return salaService.crear(sala);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Integer id, @RequestBody Sala datos) {
        return salaService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return salaService.eliminar(id);
    }
}
