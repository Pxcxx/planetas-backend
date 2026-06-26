package com.exam.planetas.service.impl;

import com.exam.planetas.dto.PlanetaRequest;
import com.exam.planetas.dto.PlanetaResponse;
import com.exam.planetas.entity.Planeta;
import com.exam.planetas.exception.ResourceNotFoundException;
import com.exam.planetas.mapper.PlanetaMapper;
import com.exam.planetas.repository.PlanetaRepository;
import com.exam.planetas.service.PlanetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanetaServiceImpl implements PlanetaService {

    private final PlanetaRepository planetaRepository;
    private final PlanetaMapper planetaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PlanetaResponse> listar() {
        return planetaRepository.findAll()
                .stream()
                .map(planetaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PlanetaResponse buscarPorId(Long id) {
        Planeta planeta = planetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Planeta no encontrado con id: " + id));
        return planetaMapper.toResponse(planeta);
    }

    @Override
    @Transactional
    public PlanetaResponse guardar(PlanetaRequest request) {
        Planeta planeta = planetaMapper.toEntity(request);
        Planeta planetaGuardado = planetaRepository.save(planeta);
        return planetaMapper.toResponse(planetaGuardado);
    }

    @Override
    @Transactional
    public PlanetaResponse actualizar(Long id, PlanetaRequest request) {
        Planeta planeta = planetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Planeta no encontrado con id: " + id));
        planetaMapper.updateEntityFromRequest(request, planeta);
        Planeta planetaActualizado = planetaRepository.save(planeta);
        return planetaMapper.toResponse(planetaActualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Planeta planeta = planetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Planeta no encontrado con id: " + id));
        planetaRepository.delete(planeta);
    }
}
