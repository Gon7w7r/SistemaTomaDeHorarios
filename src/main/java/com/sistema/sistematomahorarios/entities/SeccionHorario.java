package com.sistema.sistematomahorarios.entities;

import jakarta.persistence.*;

@Entity
@Table(name="seccion_horario")
@IdClass(SeccionHorarioId.class)
public class SeccionHorario {

    @Id
    @ManyToOne
    @JoinColumn(name="seccion_id_seccion")
    private Seccion seccion;

    @Id
    @ManyToOne
    @JoinColumn(name="horario_id_horario")
    private Horario horario;

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

}
