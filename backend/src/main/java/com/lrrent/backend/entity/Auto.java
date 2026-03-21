package com.lrrent.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "auto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modello;
    private Integer anno;
    private String carburante;
    private String cambio;
    private Double prezzoGiornaliero;
    private Boolean disponibile;
}