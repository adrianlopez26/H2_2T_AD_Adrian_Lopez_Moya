package com.empresa.paro.controller;

import com.empresa.paro.service.ParoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnalisisPagina3Controller {

    @Autowired
    private ParoService paroService;

    @GetMapping("/pagina3")
    public String mostrarResultadosPagina3(
                @RequestParam(required = false) String sexo,
                @RequestParam(required = false) String edad,
                @RequestParam(required = false) String anio,
                Model model) {
        List<Object[]> resultados = paroService.findPromedioDesempleoPorPeriodoFiltrado(
                (sexo != null && !sexo.isEmpty()) ? sexo : null,
                (edad != null && !edad.isEmpty()) ? edad : null,
                (anio != null && !anio.isEmpty()) ? anio : null
        );
        model.addAttribute("resultados", resultados);
        return "pagina3";
    }
}