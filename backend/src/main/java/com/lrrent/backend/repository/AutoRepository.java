package com.lrrent.backend.repository;

import com.lrrent.backend.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {

    List<Auto> findByDisponibile(Boolean disponibile);

    List<Auto> findByCarburante(String carburante);

    List<Auto> findByPrezzoGiornalieroLessThanEqual(Double prezzo);
}