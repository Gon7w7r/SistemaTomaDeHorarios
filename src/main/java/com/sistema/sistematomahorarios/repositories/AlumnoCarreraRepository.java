package com.sistema.sistematomahorarios.repositories;

import com.sistema.sistematomahorarios.entities.AlumnoCarrera;
import com.sistema.sistematomahorarios.entities.AlumnoCarreraId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AlumnoCarreraRepository extends JpaRepository<AlumnoCarrera, AlumnoCarreraId> {
    List<AlumnoCarrera> findByAlumnoIdAlumno(Integer idAlumno);
}
