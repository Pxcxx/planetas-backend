package com.exam.planetas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "planeta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @Column(name = "diametro", nullable = false)
    private Double diametro;

    @Column(name = "masa", nullable = false)
    private Double masa;

    @Column(name = "distancia_sol", nullable = false)
    private Double distanciaSol;

    @Column(name = "habitantes", nullable = false)
    private Long habitantes;

    @Column(name = "tiene_lunas", nullable = false)
    private Boolean tieneLunas;
}
