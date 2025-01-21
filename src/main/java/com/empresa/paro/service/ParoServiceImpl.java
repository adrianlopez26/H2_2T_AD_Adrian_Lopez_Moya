package com.empresa.paro.service;

import com.empresa.paro.repository.ParoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParoServiceImpl implements ParoService {

    @Autowired
    private ParoRepository paroRepository;

    @Override
    public List<Object[]> getTotalDesempleoPorComunidad() {
        return paroRepository.findTotalDesempleoPorComunidad();
    }

    @Override
    public List<Object[]> getPorcentajeDesempleoPorSexo() {
        return paroRepository.findPorcentajeDesempleoPorSexo();
    }

    @Override
    public List<Object[]> getPromedioDesempleoPorPeriodo() {
        return paroRepository.findPromedioDesempleoPorPeriodo();
    }

    @Override
    public List<Object[]> getDesempleoPorEdad() {
        return paroRepository.findDesempleoPorEdad();
    }

    @Override
    public List<Object[]> getComunidadConMayorDesempleo() {
        return paroRepository.findComunidadConMayorDesempleo();
    }

    @Override
    public List<Object[]> getComunidadConMenorDesempleo() {
        return paroRepository.findComunidadConMenorDesempleo();
    }

    @Override
    public List<Object[]> getConteoDesempleoPorSexo() {
        return paroRepository.findConteoDesempleoPorSexo();
    }

    @Override
    public List<Object[]> getDesempleoPorPeriodo() {
        return paroRepository.findDesempleoPorPeriodo();
    }

    @Override
    public List<Object[]> getPromedioDesempleoPorEdad() {
        return paroRepository.findPromedioDesempleoPorEdad();
    }

    @Override
    public List<Object[]> getComunidadConMayorParo() {
        return paroRepository.findComunidadConMayorParo();
    }
}
