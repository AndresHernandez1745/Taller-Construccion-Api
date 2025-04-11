package com.gestionAnn.persistence.mapper;

import com.gestionAnn. domain.dto.PagoDTO;
import com.gestionAnn.domain.entity.Pago;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "monto", source = "monto")
    @Mapping(target = "metodoPago", source = "metodoPago")
    @Mapping(target = "fechaPago", source = "fechaPago")
    @Mapping(target = "reservaId", source = "reserva.id")
    PagoDTO toDto(Pago pago);

    @InheritInverseConfiguration
    @Mapping(target = "reserva", ignore = true)
    Pago toEntity(PagoDTO pagoDTO);
}
