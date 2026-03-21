package com.lrrent.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String cognomeCliente;
    private String emailCliente;

    private LocalDate dataInizio;
    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(name = "auto_id", nullable = false)
    private Auto auto;
}