package com.gestionAnn.persistence.crud;


import com.gestionAnn.domain.entity.Consumidor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConsumidorCrudRepository extends CrudRepository<Consumidor, Long> {
    Optional<Consumidor > findByCorreo(String correo);
}
