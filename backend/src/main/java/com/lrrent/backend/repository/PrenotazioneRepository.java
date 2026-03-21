package com.lrrent.backend.repository;

import com.lrrent.backend.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByAutoId(Long autoId);

    List<Prenotazione> findByAutoIdAndDataInizioLessThanEqualAndDataFineGreaterThanEqual(
            Long autoId,
            LocalDate dataFine,
            LocalDate dataInizio
    );
}