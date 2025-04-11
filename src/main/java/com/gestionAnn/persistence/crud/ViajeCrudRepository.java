package com.gestionAnn.persistence.crud;


import com.gestionAnn.domain.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeCrudRepository extends JpaRepository<Viaje, Long> {
}