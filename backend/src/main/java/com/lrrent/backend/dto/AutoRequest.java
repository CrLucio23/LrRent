package com.lrrent.backend.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoRequest {

    @NotBlank(message = "La marca è obbligatoria")
    private String marca;

    @NotBlank(message = "Il modello è obbligatorio")
    private String modello;

    @NotNull(message = "L'anno è obbligatorio")
    @Min(value = 2000, message = "L'anno deve essere valido")
    private Integer anno;

    @NotBlank(message = "Il carburante è obbligatorio")
    private String carburante;

    @NotBlank(message = "Il cambio è obbligatorio")
    private String cambio;

    @NotNull(message = "Il prezzo giornaliero è obbligatorio")
    @Positive(message = "Il prezzo deve essere positivo")
    private Double prezzoGiornaliero;

    @NotNull(message = "La disponibilità è obbligatoria")
    private Boolean disponibile;
}