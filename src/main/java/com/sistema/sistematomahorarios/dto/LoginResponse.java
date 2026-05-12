package com.sistema.sistematomahorarios.dto;

public class LoginResponse {

    private Integer idAlumno;
    private String rut;
    private String nombre;
    private String tipoUsuario;

    public LoginResponse(Integer idAlumno, String rut, String nombre, String tipoUsuario) {
        this.idAlumno = idAlumno;
        this.rut = rut;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}