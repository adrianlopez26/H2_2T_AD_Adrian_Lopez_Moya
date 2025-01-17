package com.empresa.paro.repository;

import com.empresa.paro.entity.Paro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ParoRepository extends JpaRepository<Paro, Integer> {

    @Query("SELECT c.comunidad, SUM(p.total) FROM Paro p JOIN p.comunidad c GROUP BY c.comunidad")
    List<Object[]> totalDesempleoPorComunidad();

    @Query("SELECT p.sexo, SUM(p.total) FROM Paro p WHERE p.comunidad.codigo = :codigo GROUP BY p.sexo")
    List<Object[]> totalPorSexoEnComunidad(@Param("codigo") String codigo);
}

