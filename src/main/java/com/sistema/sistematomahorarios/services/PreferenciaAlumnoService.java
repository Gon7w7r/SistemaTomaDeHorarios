package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.dto.PreferenciaAlumnoRequestDTO;
import com.sistema.sistematomahorarios.entities.PreferenciaAlumno;
import com.sistema.sistematomahorarios.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Service
public class PreferenciaAlumnoService {

    @Autowired
    private PreferenciaAlumnoRepository preferenciaAlumnoRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private PeriodoRepository periodoRepository;

    @Transactional
    public PreferenciaAlumno guardarPreferencia(Integer idAlumno, PreferenciaAlumnoRequestDTO dto) {
        Optional<PreferenciaAlumno> existente = preferenciaAlumnoRepository
                .findByAlumnoIdAlumnoAndPeriodoIdPeriodo(idAlumno, dto.getIdPeriodo());

        PreferenciaAlumno preferencia = existente.orElse(new PreferenciaAlumno());
        preferencia.setAlumno(alumnoRepository.findById(idAlumno).orElseThrow());
        preferencia.setPeriodo(periodoRepository.findById(dto.getIdPeriodo()).orElseThrow());
        preferencia.setBloqueHorario(dto.getBloqueHorario());
        preferencia.setConcentracion(dto.getConcentracion());
        preferencia.setDiaSinClase(dto.getDiaSinClase());
        preferencia.setProfesoresPreferidos(dto.getProfesoresPreferidos());

        if (dto.getIdCompaneroPreferido() != null) {
            preferencia.setCompaneroPreferido(alumnoRepository.findById(dto.getIdCompaneroPreferido()).orElseThrow());
        } else {
            preferencia.setCompaneroPreferido(null);
        }

        return preferenciaAlumnoRepository.save(preferencia);
    }

    public Optional<PreferenciaAlumno> obtenerPreferencia(Integer idAlumno, Integer idPeriodo) {
        return preferenciaAlumnoRepository.findByAlumnoIdAlumnoAndPeriodoIdPeriodo(idAlumno, idPeriodo);
    }

    public List<PreferenciaAlumno> obtenerPreferenciasPorPeriodo(Integer idPeriodo) {
        return preferenciaAlumnoRepository.findByPeriodoIdPeriodo(idPeriodo);
    }
}