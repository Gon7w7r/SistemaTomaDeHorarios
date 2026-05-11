package com.sistema.sistematomahorarios.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.sistematomahorarios.entities.SeccionHorario;
import com.sistema.sistematomahorarios.entities.SeccionHorarioId;

import java.util.List;

public interface SeccionHorarioRepository extends JpaRepository<SeccionHorario,SeccionHorarioId> {
    List<SeccionHorario> findBySeccionIdSeccion(Integer idSeccion);

}
