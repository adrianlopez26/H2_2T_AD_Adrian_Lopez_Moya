package com.empresa.paro.controller;

import com.empresa.paro.service.ParoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalisisPagina2Controller {

    @Autowired
    private ParoService paroService;

    @GetMapping("/pagina2")
    public String mostrarResultadosPagina2(Model model) {
        // Asignar los resultados de las consultas al modelo
        model.addAttribute("resultadoConsulta6", paroService.getComunidadConMenorDesempleo().get(0));
        model.addAttribute("resultadoConsulta7", paroService.getConteoDesempleoPorSexo());
        model.addAttribute("resultadoConsulta8", paroService.getDesempleoPorPeriodo());
        model.addAttribute("resultadoConsulta9", paroService.getPromedioDesempleoPorEdad());
        model.addAttribute("resultadoConsulta10", paroService.getComunidadConMayorParo().get(0));
        return "pagina2"; // Nombre del archivo HTML de la vista
    }
}
