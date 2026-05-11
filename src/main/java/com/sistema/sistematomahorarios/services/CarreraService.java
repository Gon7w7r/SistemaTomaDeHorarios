package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.entities.Carrera;
import com.sistema.sistematomahorarios.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> listarTodas() {
        return carreraRepository.findAll();
    }

    public Optional<Carrera> buscarPorId(Integer id) {
        return carreraRepository.findById(id);
    }

    public List<Carrera> listarPorTipo(String tipo) {
        return carreraRepository.findByTipo(tipo);
    }

    public Carrera crear(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public String actualizar(Integer id, Carrera datos) {
        return carreraRepository.findById(id).map(c -> {
            c.setNombre(datos.getNombre());
            c.setTipo(datos.getTipo());
            carreraRepository.save(c);
            return "Carrera actualizada";
        }).orElse("Carrera no encontrada");
    }

    public String eliminar(Integer id) {
        if (!carreraRepository.existsById(id)) {
            return "Carrera no encontrada";
        }
        carreraRepository.deleteById(id);
        return "Carrera eliminada";
    }
}
