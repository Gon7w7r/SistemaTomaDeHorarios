package com.sistema.sistematomahorarios.controllers;

import com.sistema.sistematomahorarios.dto.PersistirFase1RequestDTO;
import com.sistema.sistematomahorarios.entities.SeccionNexusTemp;
import com.sistema.sistematomahorarios.enums.TipoUsuario;
import com.sistema.sistematomahorarios.security.RolRequerido;
import com.sistema.sistematomahorarios.services.NexusMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nexus-match")
public class NexusMatchController {

    @Autowired
    private NexusMatchService nexusMatchService;

    @PostMapping("/fase1")
    @RolRequerido({ TipoUsuario.ADMINISTRATIVO })
    public Object ejecutarFase1(@RequestBody Map<String, Object> payload) {
        return nexusMatchService.ejecutarFase1(payload);
    }

    @PostMapping("/fase2")
    @RolRequerido({ TipoUsuario.ADMINISTRATIVO })
    public Object ejecutarFase2(@RequestBody Map<String, Object> payload) {
        return nexusMatchService.ejecutarFase2(payload);
    }

    @PostMapping("/fase3")
    @RolRequerido({ TipoUsuario.ADMINISTRATIVO })
    public Object ejecutarFase3(@RequestBody Map<String, Object> payload) {
        return nexusMatchService.ejecutarFase3(payload);
    }

    // persiste el resultado de fase 1 con idAsignatura real
    @PostMapping("/fase1/persistir")
    @RolRequerido({ TipoUsuario.ADMINISTRATIVO })
    public List<SeccionNexusTemp> persistirFase1(@RequestBody PersistirFase1RequestDTO request) {
        return nexusMatchService.persistirFase1(request);
    }

    // recupera las secciones temp de un periodo para usarlas en fase 2 y 3
    @GetMapping("/fase1/secciones/{idPeriodo}")
    @RolRequerido({ TipoUsuario.ADMINISTRATIVO })
    public List<SeccionNexusTemp> obtenerSecciones(@PathVariable Integer idPeriodo) {
        return nexusMatchService.obtenerSeccionesTempPorPeriodo(idPeriodo);
    }
}