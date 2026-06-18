package com.sistema.sistematomahorarios.repositories;

import com.sistema.sistematomahorarios.entities.PreferenciaAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface PreferenciaAlumnoRepository extends JpaRepository<PreferenciaAlumno, Integer> {
    Optional<PreferenciaAlumno> findByAlumnoIdAlumnoAndPeriodoIdPeriodo(Integer idAlumno, Integer idPeriodo);
    List<PreferenciaAlumno> findByPeriodoIdPeriodo(Integer idPeriodo);
}