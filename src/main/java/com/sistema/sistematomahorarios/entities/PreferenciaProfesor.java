package com.sistema.sistematomahorarios.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "preferencia_profesor")
public class PreferenciaProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPreferencia;

    @ManyToOne
    @JoinColumn(name = "alumno_id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "asignatura_id_asignatura", nullable = false)
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "profesor_id_profesor", nullable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "periodo_id_periodo", nullable = false)
    private Periodo periodo;

    public Integer getIdPreferencia() { 
        return idPreferencia; 
    }

    public void setIdPreferencia(Integer id) { 
        this.idPreferencia = id; 
    }

    public Alumno getAlumno() { 
        return alumno; 
    }

    public void setAlumno(Alumno alumno) { 
        this.alumno = alumno; 
    }

    public Asignatura getAsignatura() { 
        return asignatura; 
    }

    public void setAsignatura(Asignatura asignatura) { 
        this.asignatura = asignatura; 
    }

    public Profesor getProfesor() { 
        return profesor; 
    }

    public void setProfesor(Profesor profesor) { 
        this.profesor = profesor; 
    }

    public Periodo getPeriodo() { 
        return periodo; 
    }

    public void setPeriodo(Periodo periodo) { 
        this.periodo = periodo; 
    }
}