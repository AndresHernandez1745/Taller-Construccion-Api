package com.gestionAnn.web.controller;

import com.gestionAnn.domain.dto.ConsumidorDTO;
import com.gestionAnn.domain.service.ConsumidorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumidores")
public class ConsumidorController {

    private final ConsumidorService consumidorService;

    public ConsumidorController(ConsumidorService consumidorService) {
        this.consumidorService = consumidorService;
    }

    @Operation(summary = "Obtener todos los consumidores", description = "Retorna la lista de consumidores registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente"),
            @ApiResponse(responseCode = "204", description = "No hay consumidores registrados"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<ConsumidorDTO>> getAllConsumidores() {
        List<ConsumidorDTO> consumidores = consumidorService.obtenerTodos();
        if (consumidores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(consumidores);
    }

    @Operation(summary = "Obtener consumidor por ID", description = "Busca un consumidor en el sistema por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consumidor encontrado"),
            @ApiResponse(responseCode = "404", description = "Consumidor no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ConsumidorDTO> getConsumidorById(@PathVariable Long id) {
        return consumidorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Registrar un nuevo consumidor", description = "Registra un nuevo consumidor en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consumidor registrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "El correo ya está en uso o los datos son inválidos")
    })
    @PostMapping
    public ResponseEntity<?> createConsumidor(@RequestBody ConsumidorDTO consumidorDTO) {
        if (consumidorService.obtenerPorCorreo(consumidorDTO.getCorreo()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: El correo ya está en uso.");
        }
        ConsumidorDTO nuevoConsumidor = consumidorService.guardar(consumidorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoConsumidor);
    }

    @Operation(summary = "Actualizar un consumidor", description = "Actualiza los datos de un consumidor existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consumidor actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Consumidor no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateConsumidor(@PathVariable Long id, @RequestBody ConsumidorDTO consumidorDTO) {
        if (!consumidorService.existeCliente(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Consumidor no encontrado.");
        }
        consumidorDTO.setId(id);
        return ResponseEntity.ok(consumidorService.actualizar(consumidorDTO));
    }

    @Operation(summary = "Eliminar un consumidor", description = "Elimina un consumidor del sistema por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Consumidor eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Consumidor no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsumidor(@PathVariable Long id) {
        if (!consumidorService.existeCliente(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Consumidor no encontrado.");
        }
        consumidorService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

