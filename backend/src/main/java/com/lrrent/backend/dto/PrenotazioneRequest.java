package com.lrrent.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrenotazioneRequest {

    @NotNull(message = "L'id dell'auto è obbligatorio")
    private Long autoId;

    @NotBlank(message = "Il nome è obbligatorio")
    private String nomeCliente;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognomeCliente;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "L'email non è valida")
    private String emailCliente;

    @NotNull(message = "La data di inizio è obbligatoria")
    @FutureOrPresent(message = "La data di inizio non può essere nel passato")
    private LocalDate dataInizio;

    @NotNull(message = "La data di fine è obbligatoria")
    private LocalDate dataFine;
}