package com.lrrent.backend.controller;

import com.lrrent.backend.dto.PrenotazioneRequest;
import com.lrrent.backend.entity.Prenotazione;
import com.lrrent.backend.service.PrenotazioneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
@CrossOrigin
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping
    public List<Prenotazione> getAll() {
        return prenotazioneService.getAll();
    }

    @GetMapping("/auto/{autoId}")
    public List<Prenotazione> getByAuto(@PathVariable Long autoId) {
        return prenotazioneService.getByAutoId(autoId);
    }

    @PostMapping
    public Prenotazione create(@RequestBody PrenotazioneRequest request) {
        return prenotazioneService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        prenotazioneService.delete(id);
    }
}