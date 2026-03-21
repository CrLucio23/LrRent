package com.lrrent.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoResponse {

    private Long id;
    private String marca;
    private String modello;
    private Integer anno;
    private String carburante;
    private String cambio;
    private Double prezzoGiornaliero;
    private Boolean disponibile;
}