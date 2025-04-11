package com.gestionAnn.persistence.mapper;

import com.gestionAnn. domain.dto.ReservaDTO;
import com.gestionAnn.domain.entity.Reserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fechaReserva", source = "fechaReserva")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "consumidorId", source = "consumidor.id")
    @Mapping(target = "viajeId", source = "viaje.id")
    ReservaDTO toDto(Reserva reserva);

    @InheritInverseConfiguration
    @Mapping(target = "consumidor", ignore = true)
    @Mapping(target = "viaje", ignore = true)
    Reserva toEntity(ReservaDTO reservaDTO);
}

