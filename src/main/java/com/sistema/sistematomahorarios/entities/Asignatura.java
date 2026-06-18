package com.sistema.sistematomahorarios.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignatura;

    @Column(nullable = false)
    private String nombre;
    
    private Integer nivel;

    @ManyToOne
    @JoinColumn(name = "departamento_id_departamento", nullable = false)
    private Departamento departamento;

    @Column(name = "tipo_sala")
    private String tipoSala;

    @Column(name = "requiere_pc", nullable = false)
    private Boolean requierePc = false;

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getTipoSala() { 
        return tipoSala; 
    }

    public void setTipoSala(String tipoSala) { 
        this.tipoSala = tipoSala; 
    }

    public Boolean getRequierePc() { 
        return requierePc; 
    }

    public void setRequierePc(Boolean requierePc) { 
        this.requierePc = requierePc; 
    }

}
