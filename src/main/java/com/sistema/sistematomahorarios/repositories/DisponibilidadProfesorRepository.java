package com.sistema.sistematomahorarios.repositories;

import com.sistema.sistematomahorarios.entities.DisponibilidadProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DisponibilidadProfesorRepository extends JpaRepository<DisponibilidadProfesor, Integer> {
    List<DisponibilidadProfesor> findByProfesorIdProfesorAndPeriodoIdPeriodo(Integer idProfesor, Integer idPeriodo);
    List<DisponibilidadProfesor> findByPeriodoIdPeriodo(Integer idPeriodo);
}