package com.sistema.sistematomahorarios.repositories;

import com.sistema.sistematomahorarios.entities.SeccionNexusTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SeccionNexusTempRepository extends JpaRepository<SeccionNexusTemp, Integer> {
    List<SeccionNexusTemp> findByIdPeriodo(Integer idPeriodo);

    @Transactional
    void deleteByIdPeriodo(Integer idPeriodo);
}