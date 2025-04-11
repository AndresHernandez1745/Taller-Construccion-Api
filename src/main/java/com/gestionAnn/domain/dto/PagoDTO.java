package com.gestionAnn.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PagoDTO {
    private Long id;
    private Double monto;
    private String metodoPago;
    private LocalDate fechaPago;
    private Long reservaId;
}
