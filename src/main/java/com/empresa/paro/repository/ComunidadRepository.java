// ComunidadRepository.java
package com.empresa.paro.repository;

import com.empresa.paro.entity.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, String> {}