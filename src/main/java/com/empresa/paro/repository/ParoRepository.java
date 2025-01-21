package com.empresa.paro.repository;

import com.empresa.paro.entity.Paro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParoRepository extends JpaRepository<Paro, Integer> {

    @Query("SELECT c.comunidad, SUM(p.total) FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad")
    List<Object[]> totalDesempleoPorComunidad();

    @Query("SELECT p.sexo, SUM(p.total) FROM Paro p GROUP BY p.sexo")
    List<Object[]> totalDesempleoPorSexo();

    @Query("SELECT p.edad, SUM(p.total) FROM Paro p GROUP BY p.edad")
    List<Object[]> totalDesempleoPorEdad();

    @Query("SELECT c.comunidad, AVG(p.total) FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad")
    List<Object[]> promedioDesempleoPorComunidad();

    @Query("SELECT c.comunidad, SUM(p.total) AS total FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad ORDER BY total DESC LIMIT 1")
    List<Object[]> comunidadConMayorDesempleo();

    @Query("SELECT c.comunidad, SUM(p.total) AS total FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad ORDER BY total ASC LIMIT 1")
    List<Object[]> comunidadConMenorDesempleo();

    @Query("SELECT c.comunidad, p.sexo, SUM(p.total) FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad, p.sexo")
    List<Object[]> desempleoPorSexoYComunidad();

    @Query("SELECT c.comunidad, p.periodo, SUM(p.total) FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad, p.periodo ORDER BY c.comunidad, p.periodo")
    List<Object[]> tendenciaDesempleoPorPeriodo();

    @Query("""
           SELECT c.comunidad, p.sexo,
                  (SUM(p.total) / (SELECT SUM(p2.total) FROM Paro p2 WHERE p2.comunidad.codigo = c.codigo) * 100) 
           FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad, p.sexo
           """)
    List<Object[]> porcentajeDesempleoPorSexo();

    @Query("SELECT c.comunidad, SUM(p.total) FROM Paro p JOIN p.comunidad c WHERE p.edad = '25-34' GROUP BY c.comunidad")
    List<Object[]> desempleoPorComunidadYRangoEdad();
}
