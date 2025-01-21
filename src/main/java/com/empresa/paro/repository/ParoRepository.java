package com.empresa.paro.repository;

import com.empresa.paro.entity.Paro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParoRepository extends CrudRepository<Paro, Integer> {

    // Consulta 1: Total desempleo por comunidad
    @Query(value = "SELECT c.Comunidad, SUM(p.Total) AS Total FROM paro p JOIN comunidad c ON p.CodigoComunidad = c.Codigo GROUP BY c.Comunidad", nativeQuery = true)
    List<Object[]> findTotalDesempleoPorComunidad();

    // Consulta 2: Porcentaje de desempleo por sexo
    @Query(value = "SELECT Sexo, (SUM(Total) / (SELECT SUM(Total) FROM paro) * 100) AS Porcentaje FROM paro GROUP BY Sexo", nativeQuery = true)
    List<Object[]> findPorcentajeDesempleoPorSexo();

    // Consulta 3: Promedio de desempleo por período
    @Query(value = "SELECT Periodo, AVG(Total) AS Promedio FROM paro GROUP BY Periodo", nativeQuery = true)
    List<Object[]> findPromedioDesempleoPorPeriodo();

    // Consulta 4: Total de desempleo por edad
    @Query(value = "SELECT Edad, SUM(Total) AS Total FROM paro GROUP BY Edad", nativeQuery = true)
    List<Object[]> findDesempleoPorEdad();

    // Consulta 5: Comunidad con mayor desempleo
    @Query(value = "SELECT c.Comunidad, SUM(p.Total) AS Total FROM paro p JOIN comunidad c ON p.CodigoComunidad = c.Codigo GROUP BY c.Comunidad ORDER BY Total DESC LIMIT 1", nativeQuery = true)
    List<Object[]> findComunidadConMayorDesempleo();

    // Consulta 6: Comunidad con menor desempleo
    @Query(value = "SELECT c.Comunidad, SUM(p.Total) AS Total FROM paro p JOIN comunidad c ON p.CodigoComunidad = c.Codigo GROUP BY c.Comunidad ORDER BY Total ASC LIMIT 1", nativeQuery = true)
    List<Object[]> findComunidadConMenorDesempleo();

    // Consulta 7: Conteo de desempleo por sexo
    @Query(value = "SELECT Sexo, COUNT(*) AS Total FROM paro GROUP BY Sexo", nativeQuery = true)
    List<Object[]> findConteoDesempleoPorSexo();

    // Consulta 8: Total de desempleo por periodo
    @Query(value = "SELECT Periodo, SUM(Total) AS Total FROM paro GROUP BY Periodo", nativeQuery = true)
    List<Object[]> findDesempleoPorPeriodo();

    // Consulta 9: Promedio de desempleo por edad
    @Query(value = "SELECT Edad, AVG(Total) AS Promedio FROM paro GROUP BY Edad", nativeQuery = true)
    List<Object[]> findPromedioDesempleoPorEdad();

    // Consulta 10: Comunidad con mayor paro
    @Query(value = "SELECT c.Comunidad, MAX(p.Total) AS Mayor FROM paro p JOIN comunidad c ON p.CodigoComunidad = c.Codigo GROUP BY c.Comunidad ORDER BY Mayor DESC LIMIT 1", nativeQuery = true)
    List<Object[]> findComunidadConMayorParo();
}
