package com.lrrent.backend.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrenotazioneRequest {

    private Long autoId;
    private String nomeCliente;
    private String cognomeCliente;
    private String emailCliente;
    private LocalDate dataInizio;
    private LocalDate dataFine;
}