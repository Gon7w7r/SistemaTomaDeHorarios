package com.sistema.sistematomahorarios.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sistema.sistematomahorarios.dto.InscripcionResponseDTO;
import com.sistema.sistematomahorarios.entities.Alumno;
import com.sistema.sistematomahorarios.entities.Inscripcion;
import com.sistema.sistematomahorarios.entities.Periodo;
import com.sistema.sistematomahorarios.entities.Seccion;
import com.sistema.sistematomahorarios.entities.SeccionHorario;
import com.sistema.sistematomahorarios.repositories.AlumnoRepository;
import com.sistema.sistematomahorarios.repositories.InscripcionRepository;
import com.sistema.sistematomahorarios.repositories.PeriodoRepository;
import com.sistema.sistematomahorarios.repositories.SeccionHorarioRepository;
import com.sistema.sistematomahorarios.repositories.SeccionRepository;

import java.util.ArrayList;
import java.util.List;  

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private SeccionHorarioRepository seccionHorarioRepository;

    @Autowired
    private SeccionRepository seccionRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private PeriodoRepository periodoRepository;

    // 🔥 MÉTODO PRINCIPAL
    public String inscribir(Integer idAlumno, Integer idSeccion, Integer idPeriodo) {

        // 1. Validar duplicado
        if (inscripcionRepository.existsByAlumnoIdAlumnoAndSeccionIdSeccion(idAlumno, idSeccion)) {
            return "El alumno ya está inscrito en esta sección";
        }

        // 2. Validar cupos
        long inscritos = inscripcionRepository.countBySeccionIdSeccion(idSeccion);

        Seccion seccion = seccionRepository.findById(idSeccion).orElseThrow();
        if (
            inscripcionRepository
                .existsByAlumnoIdAlumnoAndSeccionAsignaturaIdAsignatura(
                    idAlumno,
                    seccion.getAsignatura().getIdAsignatura()
                )
        ) {
            return "El alumno ya está inscrito en esta asignatura";
        }

        if (inscritos >= seccion.getCupos()) {
            return "No hay cupos disponibles";
        }

        // 3. Validar choque de horario
        if (tieneChoqueHorario(idAlumno, idSeccion)) {
            return "Existe choque de horario";
        }

        // 4. Crear inscripción
        Inscripcion inscripcion = new Inscripcion();

        inscripcion.setAlumno(alumnoRepository.findById(idAlumno).orElseThrow());
        inscripcion.setSeccion(seccion);
        inscripcion.setPeriodo(periodoRepository.findById(idPeriodo).orElseThrow());
        inscripcion.setFecha(LocalDateTime.now());

        inscripcionRepository.save(inscripcion);

        return "Inscripción exitosa";
    }

        private boolean tieneChoqueHorario(Integer idAlumno, Integer idSeccionNueva) {

        // horarios de la nueva sección
        List<SeccionHorario> nueva = seccionHorarioRepository.findBySeccionIdSeccion(idSeccionNueva);

        // inscripciones actuales del alumno
        List<Inscripcion> actuales = inscripcionRepository.findByAlumnoIdAlumno(idAlumno);

        for (Inscripcion insc : actuales) {

            List<SeccionHorario> existentes =
                    seccionHorarioRepository.findBySeccionIdSeccion(insc.getSeccion().getIdSeccion());

            for (SeccionHorario h1 : nueva) {
                for (SeccionHorario h2 : existentes) {

                    if (esMismoDia(h1, h2) && hayCruceHoras(h1, h2)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


        private boolean esMismoDia(SeccionHorario h1, SeccionHorario h2) {
            return h1.getHorario().getDiaSemana().equals(h2.getHorario().getDiaSemana());
        }

            private boolean hayCruceHoras(SeccionHorario h1, SeccionHorario h2) {

            var inicio1 = h1.getHorario().getHoraInicio();
            var fin1 = h1.getHorario().getHoraFin();

            var inicio2 = h2.getHorario().getHoraInicio();
            var fin2 = h2.getHorario().getHoraFin();

            return inicio1.isBefore(fin2) && fin1.isAfter(inicio2);
        }

    public List<InscripcionResponseDTO> obtenerPorAlumno(Integer idAlumno) {

    List<Inscripcion> inscripciones =
            inscripcionRepository.findByAlumnoIdAlumno(idAlumno);

        return inscripciones.stream()
                .map(i -> new InscripcionResponseDTO(
                        i.getSeccion().getAsignatura().getIdAsignatura(),
                        i.getSeccion().getAsignatura().getNombre(),
                        i.getSeccion().getIdSeccion()
                ))
                .toList();
    }

    public List<String> inscribirMultiple(
            Integer idAlumno,
            List<Integer> secciones,
            Integer idPeriodo
    ) {

        List<String> resultados = new ArrayList<>();

        for (Integer idSeccion : secciones) {

            String resultado = inscribir(
                    idAlumno,
                    idSeccion,
                    idPeriodo
            );

            resultados.add(
                    "Sección " + idSeccion + ": " + resultado
            );
        }

        return resultados;
    }

    @Transactional
    public List<String> actualizarHorario(
            Integer idAlumno,
            List<Integer> nuevasSecciones,
            Integer idPeriodo
    ) {

        // Eliminar TODO el horario actual del alumno
        inscripcionRepository.deleteByAlumnoIdAlumnoAndPeriodoIdPeriodo(
                idAlumno,
                idPeriodo
        );

        List<String> resultados = new ArrayList<>();

        for (Integer idSeccion : nuevasSecciones) {

            String resultado = inscribir(
                    idAlumno,
                    idSeccion,
                    idPeriodo
            );

            resultados.add(
                    "Sección " + idSeccion + ": " + resultado
            );
        }

        return resultados;
    }


}
