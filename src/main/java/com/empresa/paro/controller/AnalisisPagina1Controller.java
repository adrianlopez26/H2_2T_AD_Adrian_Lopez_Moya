package com.empresa.paro.controller;

import com.empresa.paro.service.ParoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalisisPagina1Controller {

    @Autowired
    private ParoService paroService;

    @GetMapping("/pagina1")
    public String mostrarResultadosPagina1(Model model) {
        // Asignar los resultados de las consultas al modelo
        model.addAttribute("resultadoConsulta1", paroService.getTotalDesempleoPorComunidad());
        model.addAttribute("resultadoConsulta2", paroService.getPorcentajeDesempleoPorSexo());
        model.addAttribute("resultadoConsulta3", paroService.getPromedioDesempleoPorPeriodo());
        model.addAttribute("resultadoConsulta4", paroService.getDesempleoPorEdad());
        model.addAttribute("resultadoConsulta5", paroService.getComunidadConMayorDesempleo().get(0));
        return "pagina1"; // Nombre del archivo HTML de la vista
    }
}
