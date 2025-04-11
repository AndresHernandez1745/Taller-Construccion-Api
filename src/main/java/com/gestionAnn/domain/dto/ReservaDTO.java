package com.gestionAnn.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservaDTO {
    private Long id;
    private LocalDate fechaReserva;
    private String estado;
    private Long consumidorId;
    private Long viajeId;
}
