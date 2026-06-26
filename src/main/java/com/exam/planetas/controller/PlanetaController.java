package com.exam.planetas.controller;

import com.exam.planetas.dto.PlanetaRequest;
import com.exam.planetas.dto.PlanetaResponse;
import com.exam.planetas.service.PlanetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/planetas")
@RequiredArgsConstructor
@Tag(name = "Planetas", description = "Operaciones CRUD para la gestión de planetas")

public class PlanetaController {

    private final PlanetaService planetaService;

    @GetMapping
    @Operation(summary = "Listar todos los planetas", description = "Retorna una lista con todos los planetas registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de planetas obtenida exitosamente")
    })
    public ResponseEntity<List<PlanetaResponse>> listar() {
        List<PlanetaResponse> planetas = planetaService.listar();
        return ResponseEntity.ok(planetas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar planeta por ID", description = "Retorna un planeta específico según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Planeta encontrado"),
            @ApiResponse(responseCode = "404", description = "Planeta no encontrado")
    })
    public ResponseEntity<PlanetaResponse> buscarPorId(
            @Parameter(description = "ID del planeta a buscar") @PathVariable Long id) {
        PlanetaResponse planeta = planetaService.buscarPorId(id);
        return ResponseEntity.ok(planeta);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo planeta", description = "Registra un nuevo planeta en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Planeta creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    public ResponseEntity<PlanetaResponse> guardar(@Valid @RequestBody PlanetaRequest request) {
        PlanetaResponse planetaGuardado = planetaService.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetaGuardado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un planeta", description = "Actualiza los datos de un planeta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Planeta actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud"),
            @ApiResponse(responseCode = "404", description = "Planeta no encontrado")
    })
    public ResponseEntity<PlanetaResponse> actualizar(
            @Parameter(description = "ID del planeta a actualizar") @PathVariable Long id,
            @Valid @RequestBody PlanetaRequest request) {
        PlanetaResponse planetaActualizado = planetaService.actualizar(id, request);
        return ResponseEntity.ok(planetaActualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un planeta", description = "Elimina un planeta de la base de datos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Planeta eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Planeta no encontrado")
    })
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del planeta a eliminar") @PathVariable Long id) {
        planetaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
