package com.lrrent.backend.service;

import com.lrrent.backend.dto.AutoResponse;
import com.lrrent.backend.entity.Auto;
import com.lrrent.backend.repository.AutoRepository;
import org.springframework.stereotype.Service;
import com.lrrent.backend.repository.PrenotazioneRepository;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;
import com.lrrent.backend.dto.AutoRequest;

@Service
public class AutoService {

    private final AutoRepository autoRepository;
    private final PrenotazioneRepository prenotazioneRepository;


    public AutoService(AutoRepository autoRepository, PrenotazioneRepository prenotazioneRepository) {
        this.autoRepository = autoRepository;
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public List<AutoResponse> getAll() {
        return autoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public AutoResponse save(AutoRequest request) {
        Auto auto = mapToEntity(request);
        Auto saved = autoRepository.save(auto);
        return mapToResponse(saved);
    }

    public AutoResponse getById(Long id) {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto non trovata"));

        return mapToResponse(auto);
    }

    public void delete(Long id) {
        autoRepository.deleteById(id);
    }

    public Auto getEntityById(Long id) {
        return autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto non trovata"));
    }


    public AutoResponse update(Long id, AutoRequest request) {
        Auto auto = getEntityById(id);

        auto.setMarca(request.getMarca());
        auto.setModello(request.getModello());
        auto.setAnno(request.getAnno());
        auto.setCarburante(request.getCarburante());
        auto.setCambio(request.getCambio());
        auto.setPrezzoGiornaliero(request.getPrezzoGiornaliero());
        auto.setDisponibile(request.getDisponibile());

        Auto saved = autoRepository.save(auto);
        return mapToResponse(saved);
    }

    public List<AutoResponse> filter(Boolean disponibile, String carburante, Double prezzoMax) {

        List<Auto> result;

        if (disponibile != null) {
            result = autoRepository.findByDisponibile(disponibile);
        } else if (carburante != null) {
            result = autoRepository.findByCarburante(carburante);
        } else if (prezzoMax != null) {
            result = autoRepository.findByPrezzoGiornalieroLessThanEqual(prezzoMax);
        } else {
            result = autoRepository.findAll();
        }

        return result.stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<AutoResponse> findDisponibili(LocalDate dataInizio, LocalDate dataFine) {

        return autoRepository.findAll().stream()
                .filter(auto -> {
                    boolean occupata = prenotazioneRepository
                            .existsByAutoIdAndDataInizioLessThanEqualAndDataFineGreaterThanEqual(
                                    auto.getId(),
                                    dataFine,
                                    dataInizio
                            );
                    return !occupata;
                })
                .map(this::mapToResponse)
                .toList();
    }

    private AutoResponse mapToResponse(Auto auto) {
        return AutoResponse.builder()
                .id(auto.getId())
                .marca(auto.getMarca())
                .modello(auto.getModello())
                 .anno(auto.getAnno())
                .carburante(auto.getCarburante())
                .cambio(auto.getCambio())
                .prezzoGiornaliero(auto.getPrezzoGiornaliero())
                .disponibile(auto.getDisponibile())
                .build();
    }

    private Auto mapToEntity(AutoRequest request) {
        return Auto.builder()
                .marca(request.getMarca())
                .modello(request.getModello())
                .anno(request.getAnno())
                .carburante(request.getCarburante())
                .cambio(request.getCambio())
                .prezzoGiornaliero(request.getPrezzoGiornaliero())
                .disponibile(request.getDisponibile())
                .build();
    }
}