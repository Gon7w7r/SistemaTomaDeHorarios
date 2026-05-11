package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.entities.Sala;
import com.sistema.sistematomahorarios.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> buscarPorId(Integer id) {
        return salaRepository.findById(id);
    }

    public List<Sala> listarPorSede(Integer idSede) {
        return salaRepository.findBySedeIdSede(idSede);
    }

    public Sala crear(Sala sala) {
        return salaRepository.save(sala);
    }

    public String actualizar(Integer id, Sala datos) {
        return salaRepository.findById(id).map(s -> {
            s.setNombre(datos.getNombre());
            s.setTipo(datos.getTipo());
            s.setSede(datos.getSede());
            salaRepository.save(s);
            return "Sala actualizada";
        }).orElse("Sala no encontrada");
    }

    public String eliminar(Integer id) {
        if (!salaRepository.existsById(id)) {
            return "Sala no encontrada";
        }
        salaRepository.deleteById(id);
        return "Sala eliminada";
    }
}
