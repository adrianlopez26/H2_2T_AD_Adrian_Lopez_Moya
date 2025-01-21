package com.empresa.paro.service;

import java.util.List;

public interface ParoService {
    List<Object[]> getTotalDesempleoPorComunidad();
    List<Object[]> getPorcentajeDesempleoPorSexo();
    List<Object[]> getPromedioDesempleoPorPeriodo();
    List<Object[]> getDesempleoPorEdad();
    List<Object[]> getComunidadConMayorDesempleo();

    List<Object[]> getComunidadConMenorDesempleo();
    List<Object[]> getConteoDesempleoPorSexo();
    List<Object[]> getDesempleoPorPeriodo();
    List<Object[]> getPromedioDesempleoPorEdad();
    List<Object[]> getComunidadConMayorParo();
}
