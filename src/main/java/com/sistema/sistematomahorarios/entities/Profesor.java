package com.sistema.sistematomahorarios.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesor;
    @OneToOne
    @JoinColumn(name = "usuarios_rut", nullable = false)
    private Usuario usuario;

    public Profesor() {
    }

    public Profesor(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
