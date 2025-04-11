package com.gestionAnn.persistence.crud;

import com.gestionAnn.domain.entity.Pago;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PagoCrudRepository extends CrudRepository<Pago, Long> {
    Optional<Pago> findById(Long id);
}
