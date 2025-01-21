package com.empresa.paro.controller;

import com.empresa.paro.repository.ParoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalisisController {

    @Autowired
    private ParoRepository paroRepository;

    @GetMapping("/resultados")
    public String mostrarResultados(Model model) {
        model.addAttribute("desempleoPorComunidad", paroRepository.totalDesempleoPorComunidad());
        model.addAttribute("desempleoPorSexo", paroRepository.totalDesempleoPorSexo());
        model.addAttribute("desempleoPorEdad", paroRepository.totalDesempleoPorEdad());
        model.addAttribute("promedioDesempleo", paroRepository.promedioDesempleoPorComunidad());
        model.addAttribute("mayorDesempleo", paroRepository.comunidadConMayorDesempleo());
        model.addAttribute("menorDesempleo", paroRepository.comunidadConMenorDesempleo());
        model.addAttribute("desempleoPorSexoComunidad", paroRepository.desempleoPorSexoYComunidad());
        model.addAttribute("tendenciaPorPeriodo", paroRepository.tendenciaDesempleoPorPeriodo());
        model.addAttribute("porcentajePorSexo", paroRepository.porcentajeDesempleoPorSexo());
        model.addAttribute("desempleoRangoEdad", paroRepository.desempleoPorComunidadYRangoEdad());
        return "resultados";
    }
}
