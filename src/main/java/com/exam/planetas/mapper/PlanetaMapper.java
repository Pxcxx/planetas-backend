package com.exam.planetas.mapper;

import com.exam.planetas.dto.PlanetaRequest;
import com.exam.planetas.dto.PlanetaResponse;
import com.exam.planetas.entity.Planeta;
import org.springframework.stereotype.Component;

@Component
public class PlanetaMapper {

    public PlanetaResponse toResponse(Planeta planeta) {
        return PlanetaResponse.builder()
                .id(planeta.getId())
                .nombre(planeta.getNombre())
                .diametro(planeta.getDiametro())
                .masa(planeta.getMasa())
                .distanciaSol(planeta.getDistanciaSol())
                .habitantes(planeta.getHabitantes())
                .tieneLunas(planeta.getTieneLunas())
                .build();
    }

    public Planeta toEntity(PlanetaRequest request) {
        return Planeta.builder()
                .nombre(request.getNombre())
                .diametro(request.getDiametro())
                .masa(request.getMasa())
                .distanciaSol(request.getDistanciaSol())
                .habitantes(request.getHabitantes())
                .tieneLunas(request.getTieneLunas())
                .build();
    }

    public void updateEntityFromRequest(PlanetaRequest request, Planeta planeta) {
        planeta.setNombre(request.getNombre());
        planeta.setDiametro(request.getDiametro());
        planeta.setMasa(request.getMasa());
        planeta.setDistanciaSol(request.getDistanciaSol());
        planeta.setHabitantes(request.getHabitantes());
        planeta.setTieneLunas(request.getTieneLunas());
    }
}
