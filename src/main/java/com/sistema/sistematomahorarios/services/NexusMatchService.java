package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.dto.PersistirFase1RequestDTO;
import com.sistema.sistematomahorarios.entities.SeccionNexusTemp;
import com.sistema.sistematomahorarios.repositories.SeccionNexusTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class NexusMatchService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SeccionNexusTempRepository seccionNexusTempRepository;

    @Value("${nexusmatch.url:http://localhost:8000}")
    private String nexusMatchUrl;

    public Object ejecutarFase1(Map<String, Object> payload) {
        return restTemplate.postForObject(
            nexusMatchUrl + "/fase1/generar-secciones", payload, Object.class);
    }

    public Object ejecutarFase2(Map<String, Object> payload) {
        return restTemplate.postForObject(
            nexusMatchUrl + "/fase2/calcular-scores", payload, Object.class);
    }

    public Object ejecutarFase3(Map<String, Object> payload) {
        return restTemplate.postForObject(
            nexusMatchUrl + "/fase3/asignar", payload, Object.class);
    }

    // borra las secciones anteriores del periodo y guarda las nuevas
    @Transactional
    public List<SeccionNexusTemp> persistirFase1(PersistirFase1RequestDTO request) {
        seccionNexusTempRepository.deleteByIdPeriodo(request.getIdPeriodo());

        return request.getSecciones().stream().map(dto -> {
            SeccionNexusTemp temp = new SeccionNexusTemp();
            temp.setIdProfesor(dto.getIdProfesor());
            temp.setIdAsignatura(dto.getIdAsignatura());
            temp.setIdSala(dto.getIdSala());
            temp.setJornada(dto.getJornada());
            temp.setDias(String.join(",", dto.getDias()));
            temp.setIdPeriodo(request.getIdPeriodo());
            return seccionNexusTempRepository.save(temp);
        }).toList();
    }

    public List<SeccionNexusTemp> obtenerSeccionesTempPorPeriodo(Integer idPeriodo) {
        return seccionNexusTempRepository.findByIdPeriodo(idPeriodo);
    }
}