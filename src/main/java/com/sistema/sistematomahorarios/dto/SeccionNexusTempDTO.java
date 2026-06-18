package com.sistema.sistematomahorarios.dto;

import java.util.List;

public class SeccionNexusTempDTO {
    private Integer      idProfesor;
    private Integer      idAsignatura;
    private Integer      idSala;
    private String       jornada;
    private List<String> dias;

    public Integer      getIdProfesor()             { return idProfesor; }
    public void         setIdProfesor(Integer v)    { this.idProfesor = v; }

    public Integer      getIdAsignatura()           { return idAsignatura; }
    public void         setIdAsignatura(Integer v)  { this.idAsignatura = v; }

    public Integer      getIdSala()                 { return idSala; }
    public void         setIdSala(Integer v)        { this.idSala = v; }

    public String       getJornada()                { return jornada; }
    public void         setJornada(String v)        { this.jornada = v; }

    public List<String> getDias()                   { return dias; }
    public void         setDias(List<String> v)     { this.dias = v; }
}