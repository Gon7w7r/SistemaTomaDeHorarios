package com.sistema.sistematomahorarios.entities;
import jakarta.persistence.*;


@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    @OneToOne
    @JoinColumn(name = "usuarios_rut", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "jornada_id_jornada")
    private Jornada jornada;

    public Alumno() {
    }
    
    public Alumno(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Jornada getJornada() { 
        return jornada; 
    }

    public void setJornada(Jornada jornada) { 
        this.jornada = jornada; 
    }

}
