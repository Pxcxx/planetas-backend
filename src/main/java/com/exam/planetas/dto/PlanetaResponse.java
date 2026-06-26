package com.exam.planetas.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetaResponse {

    private Long id;
    private String nombre;
    private Double diametro;
    private Double masa;
    private Double distanciaSol;
    private Long habitantes;
    private Boolean tieneLunas;
}
