package com.lrrent.backend.controller;

import com.lrrent.backend.dto.AutoResponse;
import com.lrrent.backend.entity.Auto;
import com.lrrent.backend.service.AutoService;
import org.springframework.web.bind.annotation.*;
import com.lrrent.backend.dto.AutoRequest;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/auto")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public List<AutoResponse> getAll() {
        return autoService.getAll();
    }

    @GetMapping("/{id}")
    public AutoResponse getById(@PathVariable Long id) {
        return autoService.getById(id);
    }

    @PostMapping
    public AutoResponse create(@Valid @RequestBody AutoRequest request) {
        return autoService.save(request);
    }

    @PutMapping("/{id}")
    public AutoResponse update(@PathVariable Long id, @Valid @RequestBody AutoRequest request) {
        return autoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autoService.delete(id);
    }

    @GetMapping("/filter")
    public List<AutoResponse> filter(
            @RequestParam(required = false) Boolean disponibile,
            @RequestParam(required = false) String carburante,
            @RequestParam(required = false) Double prezzoMax
    ) {
        return autoService.filter(disponibile, carburante, prezzoMax);
    }

    @GetMapping("/disponibili")
    public List<AutoResponse> getDisponibili(
            @RequestParam LocalDate dataInizio,
            @RequestParam LocalDate dataFine
    ) {
        return autoService.findDisponibili(dataInizio, dataFine);
    }


}