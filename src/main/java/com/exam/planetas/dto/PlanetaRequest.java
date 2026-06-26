package com.exam.planetas.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetaRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 80, message = "El nombre no puede superar los 80 caracteres")
    private String nombre;

    @NotNull(message = "El diámetro es obligatorio")
    @Positive(message = "El diámetro debe ser un valor positivo")
    private Double diametro;

    @NotNull(message = "La masa es obligatoria")
    @Positive(message = "La masa debe ser un valor positivo")
    private Double masa;

    @NotNull(message = "La distancia al sol es obligatoria")
    @Positive(message = "La distancia al sol debe ser un valor positivo")
    private Double distanciaSol;

    @NotNull(message = "El número de habitantes es obligatorio")
    @PositiveOrZero(message = "El número de habitantes debe ser cero o positivo")
    private Long habitantes;

    @NotNull(message = "El campo tieneLunas es obligatorio")
    private Boolean tieneLunas;
}
