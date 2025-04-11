package com.gestionAnn.domain.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumidorDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String telefono;
}