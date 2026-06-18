package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.dto.DisponibilidadProfesorRequestDTO;
import com.sistema.sistematomahorarios.entities.DisponibilidadProfesor;
import com.sistema.sistematomahorarios.entities.Horario;
import com.sistema.sistematomahorarios.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisponibilidadProfesorService {

    @Autowired
    private DisponibilidadProfesorRepository disponibilidadRepository;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private PeriodoRepository periodoRepository;
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Transactional
    public String guardarDisponibilidad(Integer idProfesor, DisponibilidadProfesorRequestDTO dto) {
        int totalBloques = dto.getIdHorarios().size();
        if (totalBloques < 5)
            return "Mínimo 5 bloques requeridos";
        if (totalBloques > 30)
            return "Máximo 30 bloques permitidos";

        disponibilidadRepository.deleteAllInBatch(
                disponibilidadRepository.findByProfesorIdProfesorAndPeriodoIdPeriodo(
                        idProfesor, dto.getIdPeriodo()));

        for (Integer idHorario : dto.getIdHorarios()) {
            Horario horario = horarioRepository.findById(idHorario).orElseThrow();
            DisponibilidadProfesor disp = new DisponibilidadProfesor();
            disp.setProfesor(profesorRepository.findById(idProfesor).orElseThrow());
            disp.setPeriodo(periodoRepository.findById(dto.getIdPeriodo()).orElseThrow());
            disp.setDiaSemana(horario.getDiaSemana());
            disp.setHoraInicio(horario.getHoraInicio());
            disp.setHoraFin(horario.getHoraFin());

            // guardar la asignatura si viene en el request
            if (dto.getIdAsignatura() != null) {
                disp.setAsignatura(
                    asignaturaRepository.findById(dto.getIdAsignatura()).orElseThrow()
                );
            }

            disponibilidadRepository.save(disp);
        }

        return "Disponibilidad guardada correctamente";
    }

    public List<DisponibilidadProfesor> obtenerDisponibilidad(Integer idProfesor, Integer idPeriodo) {
        return disponibilidadRepository.findByProfesorIdProfesorAndPeriodoIdPeriodo(idProfesor, idPeriodo);
    }

    public List<DisponibilidadProfesor> obtenerDisponibilidadPorPeriodo(Integer idPeriodo) {
        return disponibilidadRepository.findByPeriodoIdPeriodo(idPeriodo);
    }
}