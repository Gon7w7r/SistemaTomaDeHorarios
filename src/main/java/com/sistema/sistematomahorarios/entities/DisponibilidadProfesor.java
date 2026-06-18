package com.sistema.sistematomahorarios.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "disponibilidad_profesor")
public class DisponibilidadProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "profesor_id_profesor", nullable = false)
    private Profesor profesor;

    @Column(name = "dia_semana", nullable = false)
    private String diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private java.time.LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private java.time.LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "periodo_id_periodo", nullable = false)
    private Periodo periodo;

    // asignatura para la que el profesor declara disponibilidad
    @ManyToOne
    @JoinColumn(name = "asignatura_id_asignatura")
    private Asignatura asignatura;

    public Integer getIdDisponibilidad()                    { return idDisponibilidad; }
    public void setIdDisponibilidad(Integer id)             { this.idDisponibilidad = id; }

    public Profesor getProfesor()                           { return profesor; }
    public void setProfesor(Profesor profesor)              { this.profesor = profesor; }

    public String getDiaSemana()                            { return diaSemana; }
    public void setDiaSemana(String diaSemana)              { this.diaSemana = diaSemana; }

    public java.time.LocalTime getHoraInicio()              { return horaInicio; }
    public void setHoraInicio(java.time.LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public java.time.LocalTime getHoraFin()                 { return horaFin; }
    public void setHoraFin(java.time.LocalTime horaFin)     { this.horaFin = horaFin; }

    public Periodo getPeriodo()                             { return periodo; }
    public void setPeriodo(Periodo periodo)                 { this.periodo = periodo; }

    public Asignatura getAsignatura()                       { return asignatura; }
    public void setAsignatura(Asignatura asignatura)        { this.asignatura = asignatura; }
}