package com.sistema.sistematomahorarios.dto;

import java.util.List;

public class PersistirFase1RequestDTO {
    private Integer                  idPeriodo;
    private List<SeccionNexusTempDTO> secciones;

    public Integer                   getIdPeriodo()           { return idPeriodo; }
    public void                      setIdPeriodo(Integer v)  { this.idPeriodo = v; }

    public List<SeccionNexusTempDTO> getSecciones()              { return secciones; }
    public void                      setSecciones(List<SeccionNexusTempDTO> v) { this.secciones = v; }
}