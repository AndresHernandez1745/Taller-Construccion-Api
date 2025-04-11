package com.gestionAnn.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ViajeDTO {
    
    private Long id;
    private String destino;
    private String descripcion;
    private Double precio;
    private LocalDate fechaDisponible;
    private Integer duracion;
}
