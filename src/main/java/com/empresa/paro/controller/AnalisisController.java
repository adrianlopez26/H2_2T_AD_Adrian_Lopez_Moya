package com.empresa.paro.controller;

import com.empresa.paro.repository.ParoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AnalisisController {

    @Autowired
    private ParoRepository paroRepository;

    // Total de desempleo por comunidad
    @GetMapping("/total-desempleo-por-comunidad")
    public List<Object[]> totalDesempleoPorComunidad() {
        return paroRepository.totalDesempleoPorComunidad();
    }

    // Total de desempleo por sexo en una comunidad específica
    @GetMapping("/total-por-sexo")
    public List<Object[]> totalPorSexoEnComunidad(@RequestParam String codigo) {
        return paroRepository.totalPorSexoEnComunidad(codigo);
    }

}

