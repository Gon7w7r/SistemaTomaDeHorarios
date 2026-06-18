package com.sistema.sistematomahorarios.dto;

public class PreferenciaAlumnoRequestDTO {
    private Integer idPeriodo;
    private String bloqueHorario;
    private String concentracion;
    private String diaSinClase;
    private Integer idCompaneroPreferido;
    private String profesoresPreferidos;

    public Integer getIdPeriodo() { return idPeriodo; }
    public void setIdPeriodo(Integer idPeriodo) { this.idPeriodo = idPeriodo; }
    public String getBloqueHorario() { return bloqueHorario; }
    public void setBloqueHorario(String bloqueHorario) { this.bloqueHorario = bloqueHorario; }
    public String getConcentracion() { return concentracion; }
    public void setConcentracion(String concentracion) { this.concentracion = concentracion; }
    public String getDiaSinClase() { return diaSinClase; }
    public void setDiaSinClase(String diaSinClase) { this.diaSinClase = diaSinClase; }
    public Integer getIdCompaneroPreferido() { return idCompaneroPreferido; }
    public void setIdCompaneroPreferido(Integer idCompaneroPreferido) { this.idCompaneroPreferido = idCompaneroPreferido; }
    public String getProfesoresPreferidos() { return profesoresPreferidos; }
    public void setProfesoresPreferidos(String profesoresPreferidos) { this.profesoresPreferidos = profesoresPreferidos; }
}