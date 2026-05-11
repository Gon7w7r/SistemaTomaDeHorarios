package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.entities.Seccion;
import com.sistema.sistematomahorarios.repositories.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionService {

    @Autowired
    private SeccionRepository seccionRepository;

    public List<Seccion> listarTodas() {
        return seccionRepository.findAll();
    }

    public Optional<Seccion> buscarPorId(Integer id) {
        return seccionRepository.findById(id);
    }

    public List<Seccion> listarPorAsignatura(Integer idAsignatura) {
        return seccionRepository.findByAsignaturaIdAsignatura(idAsignatura);
    }

    public List<Seccion> listarPorProfesor(Integer idProfesor) {
        return seccionRepository.findByProfesorIdProfesor(idProfesor);
    }

    public Seccion crear(Seccion seccion) {
        return seccionRepository.save(seccion);
    }

    public String actualizar(Integer id, Seccion datos) {
        return seccionRepository.findById(id).map(s -> {
            s.setCupos(datos.getCupos());
            s.setAsignatura(datos.getAsignatura());
            s.setProfesor(datos.getProfesor());
            s.setSala(datos.getSala());
            s.setSede(datos.getSede());
            s.setModalidad(datos.getModalidad());
            s.setJornada(datos.getJornada());
            seccionRepository.save(s);
            return "Sección actualizada";
        }).orElse("Sección no encontrada");
    }

    public String eliminar(Integer id) {
        if (!seccionRepository.existsById(id)) {
            return "Sección no encontrada";
        }
        seccionRepository.deleteById(id);
        return "Sección eliminada";
    }
}
