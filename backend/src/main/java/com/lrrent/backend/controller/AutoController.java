package com.lrrent.backend.controller;

import com.lrrent.backend.entity.Auto;
import com.lrrent.backend.service.AutoService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Auto getById(@PathVariable Long id) {
        return autoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autoService.delete(id);
    }

    @PutMapping("/{id}")
    public Auto update(@PathVariable Long id, @RequestBody Auto auto) {
        return autoService.update(id, auto);
    }

    @GetMapping("/filter")
    public List<Auto> filter(
            @RequestParam(required = false) Boolean disponibile,
            @RequestParam(required = false) String carburante,
            @RequestParam(required = false) Double prezzoMax
    ) {
        return autoService.filter(disponibile, carburante, prezzoMax);
    }

}