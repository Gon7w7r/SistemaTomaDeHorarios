package com.sistema.sistematomahorarios.dto;

import java.util.List;

public class DisponibilidadProfesorRequestDTO {
    private Integer idPeriodo;
    private Integer idAsignatura;
    private List<Integer> idHorarios;

    public Integer getIdPeriodo()                       { return idPeriodo; }
    public void setIdPeriodo(Integer idPeriodo)         { this.idPeriodo = idPeriodo; }

    public Integer getIdAsignatura()                    { return idAsignatura; }
    public void setIdAsignatura(Integer idAsignatura)   { this.idAsignatura = idAsignatura; }

    public List<Integer> getIdHorarios()                { return idHorarios; }
    public void setIdHorarios(List<Integer> idHorarios) { this.idHorarios = idHorarios; }
}