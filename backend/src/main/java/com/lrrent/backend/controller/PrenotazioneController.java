package com.lrrent.backend.controller;

import com.lrrent.backend.dto.PrenotazioneRequest;
import com.lrrent.backend.dto.PrenotazioneResponse;
import com.lrrent.backend.service.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping
    public List<PrenotazioneResponse> getAll() {
        return prenotazioneService.getAll();
    }

    @GetMapping("/auto/{autoId}")
    public List<PrenotazioneResponse> getByAuto(@PathVariable Long autoId) {
        return prenotazioneService.getByAutoId(autoId);
    }

    @PostMapping
    public PrenotazioneResponse create(@Valid @RequestBody PrenotazioneRequest request) {
        return prenotazioneService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        prenotazioneService.delete(id);
    }
}