package com.sistema.sistematomahorarios.repositories;

import com.sistema.sistematomahorarios.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
}