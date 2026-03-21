package com.lrrent.backend.service;

import com.lrrent.backend.dto.PrenotazioneRequest;
import com.lrrent.backend.entity.Auto;
import com.lrrent.backend.entity.Prenotazione;
import com.lrrent.backend.repository.AutoRepository;
import com.lrrent.backend.repository.PrenotazioneRepository;
import org.springframework.stereotype.Service;
import com.lrrent.backend.dto.PrenotazioneResponse;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final AutoRepository autoRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, AutoRepository autoRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.autoRepository = autoRepository;
    }

    public List<PrenotazioneResponse> getAll() {
        return prenotazioneRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<PrenotazioneResponse> getByAutoId(Long autoId) {
        return prenotazioneRepository.findByAutoId(autoId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public PrenotazioneResponse create(PrenotazioneRequest request) {
        if (request.getDataInizio() == null || request.getDataFine() == null) {
            throw new RuntimeException("Le date sono obbligatorie");
        }

        if (request.getDataFine().isBefore(request.getDataInizio())) {
            throw new RuntimeException("La data di fine non può essere prima della data di inizio");
        }

        if (request.getDataInizio().isBefore(LocalDate.now())) {
            throw new RuntimeException("La data di inizio non può essere nel passato");
        }

        Auto auto = autoRepository.findById(request.getAutoId())
                .orElseThrow(() -> new RuntimeException("Auto non trovata"));

        if (Boolean.FALSE.equals(auto.getDisponibile())) {
            throw new RuntimeException("Auto non disponibile");
        }

        List<Prenotazione> sovrapposte =
                prenotazioneRepository.findByAutoIdAndDataInizioLessThanEqualAndDataFineGreaterThanEqual(
                        auto.getId(),
                        request.getDataFine(),
                        request.getDataInizio()
                );

        if (!sovrapposte.isEmpty()) {
            throw new RuntimeException("Auto già prenotata nelle date selezionate");
        }

        Prenotazione prenotazione = Prenotazione.builder()
                .nomeCliente(request.getNomeCliente())
                .cognomeCliente(request.getCognomeCliente())
                .emailCliente(request.getEmailCliente())
                .dataInizio(request.getDataInizio())
                .dataFine(request.getDataFine())
                .auto(auto)
                .build();

        Prenotazione saved = prenotazioneRepository.save(prenotazione);
        return mapToResponse(saved);
    }

    public void delete(Long id) {
        prenotazioneRepository.deleteById(id);
    }

    private PrenotazioneResponse mapToResponse(Prenotazione prenotazione) {
        return PrenotazioneResponse.builder()
                .id(prenotazione.getId())
                .nomeCliente(prenotazione.getNomeCliente())
                .cognomeCliente(prenotazione.getCognomeCliente())
                .emailCliente(prenotazione.getEmailCliente())
                .dataInizio(prenotazione.getDataInizio())
                .dataFine(prenotazione.getDataFine())
                .autoId(prenotazione.getAuto().getId())
                .autoMarca(prenotazione.getAuto().getMarca())
                .autoModello(prenotazione.getAuto().getModello())
                .build();
    }
}