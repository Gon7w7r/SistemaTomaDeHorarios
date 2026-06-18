package com.sistema.sistematomahorarios.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "asignacion_nexus_match")
public class AsignacionNexusMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacion;

    @ManyToOne
    @JoinColumn(name = "alumno_id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "seccion_id_seccion", nullable = false)
    private Seccion seccion;

    @ManyToOne
    @JoinColumn(name = "periodo_id_periodo", nullable = false)
    private Periodo periodo;

    @Column(nullable = false)
    private Double score;

    public Integer getIdAsignacion() { 
        return idAsignacion; 
    }

    public void setIdAsignacion(Integer id) { 
        this.idAsignacion = id; 
    }

    public Alumno getAlumno() { 
        return alumno; 
    }

    public void setAlumno(Alumno alumno) { 
        this.alumno = alumno; 
    }

    public Seccion getSeccion() { 
        return seccion; 
    }

    public void setSeccion(Seccion seccion) { 
        this.seccion = seccion; 
    }

    public Periodo getPeriodo() { 
        return periodo; 
    }

    public void setPeriodo(Periodo periodo) { 
        this.periodo = periodo; 
    }

    public Double getScore() { 
        return score; 
    }

    public void setScore(Double score) { 
        this.score = score; 
    }
}