package com.gestionAnn.persistence.crud;

import com.gestionAnn.domain.entity.Reserva;
import org.springframework.data.repository.CrudRepository;


public interface ReservaCrudRepository extends CrudRepository<Reserva, Long> {
}
