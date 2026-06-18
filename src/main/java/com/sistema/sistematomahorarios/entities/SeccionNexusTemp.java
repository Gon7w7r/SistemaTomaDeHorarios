package com.sistema.sistematomahorarios.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "seccion_nexus_temp")
public class SeccionNexusTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_profesor")
    private Integer idProfesor;

    @Column(name = "id_asignatura")
    private Integer idAsignatura;

    @Column(name = "id_sala")
    private Integer idSala;

    @Column(name = "jornada")
    private String jornada;

    // dias separados por coma: "Lunes,Miércoles"
    @Column(name = "dias")
    private String dias;

    @Column(name = "id_periodo")
    private Integer idPeriodo;

    public Integer getId()           { return id; }
    public void setId(Integer id)    { this.id = id; }

    public Integer getIdProfesor()              { return idProfesor; }
    public void setIdProfesor(Integer v)        { this.idProfesor = v; }

    public Integer getIdAsignatura()            { return idAsignatura; }
    public void setIdAsignatura(Integer v)      { this.idAsignatura = v; }

    public Integer getIdSala()                  { return idSala; }
    public void setIdSala(Integer v)            { this.idSala = v; }

    public String getJornada()                  { return jornada; }
    public void setJornada(String v)            { this.jornada = v; }

    public String getDias()                     { return dias; }
    public void setDias(String v)               { this.dias = v; }

    public Integer getIdPeriodo()               { return idPeriodo; }
    public void setIdPeriodo(Integer v)         { this.idPeriodo = v; }
}