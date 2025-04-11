package com.gestionAnn.persistence.mapper;

import com.gestionAnn. domain.dto.ConsumidorDTO ;
import com.gestionAnn. domain.entity.Consumidor ;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsumidorMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "correo", source = "correo")
    @Mapping(target = "telefono", source = "telefono")
    ConsumidorDTO toDto(Consumidor consumidor);

    @InheritInverseConfiguration
    //@Mapping(target = "reservas", ignore = true)
    Consumidor toEntity(ConsumidorDTO consumidorDTO );
}
