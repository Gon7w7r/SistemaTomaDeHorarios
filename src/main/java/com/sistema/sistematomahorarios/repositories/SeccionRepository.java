package com.sistema.sistematomahorarios.repositories;

import com.sistema.sistematomahorarios.entities.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeccionRepository extends JpaRepository<Seccion, Integer>{

    List<Seccion> findByAsignaturaIdAsignatura(Integer idAsignatura);

    List<Seccion> findByProfesorIdProfesor(Integer idProfesor);

}
