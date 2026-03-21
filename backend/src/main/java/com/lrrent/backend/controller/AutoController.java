package com.lrrent.backend.controller;

import com.lrrent.backend.entity.Auto;
import com.lrrent.backend.service.AutoService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/auto")
@CrossOrigin
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public List<Auto> getAll() {
        return autoService.getAll();
    }

    @PostMapping
    public Auto create(@RequestBody Auto auto) {
        return autoService.save(auto);
    }

    @GetMapping("/disponibili")
    public List<Auto> getDisponibili(
            @RequestParam LocalDate dataInizio,
            @RequestParam LocalDate dataFine
    ) {
        return autoService.findDisponibili(dataInizio, dataFine);
    }
}