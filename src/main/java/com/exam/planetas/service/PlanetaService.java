package com.exam.planetas.service;

import com.exam.planetas.dto.PlanetaRequest;
import com.exam.planetas.dto.PlanetaResponse;

import java.util.List;

public interface PlanetaService {

    List<PlanetaResponse> listar();

    PlanetaResponse buscarPorId(Long id);

    PlanetaResponse guardar(PlanetaRequest request);

    PlanetaResponse actualizar(Long id, PlanetaRequest request);

    void eliminar(Long id);
}
