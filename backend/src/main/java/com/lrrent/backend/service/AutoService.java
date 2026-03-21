package com.lrrent.backend.service;

import com.lrrent.backend.entity.Auto;
import com.lrrent.backend.repository.AutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    private final AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> getAll() {
        return autoRepository.findAll();
    }

    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }

    public Auto getById(Long id) {
        return autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto non trovata"));
    }

    public void delete(Long id) {
        autoRepository.deleteById(id);
    }

    public Auto update(Long id, Auto updatedAuto) {


        auto.setMarca(updatedAuto.getMarca());
        auto.setModello(updatedAuto.getModello());
        auto.setAnno(updatedAuto.getAnno());
        auto.setCarburante(updatedAuto.getCarburante());
        auto.setCambio(updatedAuto.getCambio());
        auto.setPrezzoGiornaliero(updatedAuto.getPrezzoGiornaliero());
        auto.setDisponibile(updatedAuto.getDisponibile());

        return autoRepository.save(auto);
    }
}