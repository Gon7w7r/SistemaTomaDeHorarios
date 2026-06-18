package com.sistema.sistematomahorarios.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "preferencia_alumno")
public class PreferenciaAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPreferencia;

    @ManyToOne
    @JoinColumn(name = "alumno_id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "periodo_id_periodo", nullable = false)
    private Periodo periodo;

    @Column(name = "bloque_horario", nullable = false)
    private String bloqueHorario;

    @Column(name = "concentracion", nullable = false)
    private String concentracion;

    @Column(name = "dia_sin_clase")
    private String diaSinClase;

    @ManyToOne
    @JoinColumn(name = "companero_preferido_id")
    private Alumno companeroPreferido;

    @Column(name = "profesores_preferidos", columnDefinition = "TEXT")
    private String profesoresPreferidos;

    public Integer getIdPreferencia() { return idPreferencia; }
    public void setIdPreferencia(Integer id) { this.idPreferencia = id; }
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
    public Periodo getPeriodo() { return periodo; }
    public void setPeriodo(Periodo periodo) { this.periodo = periodo; }
    public String getBloqueHorario() { return bloqueHorario; }
    public void setBloqueHorario(String bloqueHorario) { this.bloqueHorario = bloqueHorario; }
    public String getConcentracion() { return concentracion; }
    public void setConcentracion(String concentracion) { this.concentracion = concentracion; }
    public String getDiaSinClase() { return diaSinClase; }
    public void setDiaSinClase(String diaSinClase) { this.diaSinClase = diaSinClase; }
    public Alumno getCompaneroPreferido() { return companeroPreferido; }
    public void setCompaneroPreferido(Alumno companeroPreferido) { this.companeroPreferido = companeroPreferido; }
    public String getProfesoresPreferidos() { return profesoresPreferidos; }
    public void setProfesoresPreferidos(String profesoresPreferidos) { this.profesoresPreferidos = profesoresPreferidos; }
}