package com.lrrent.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prenotazione> prenotazioni;
}