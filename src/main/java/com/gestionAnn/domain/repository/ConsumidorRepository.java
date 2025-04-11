package com.gestionAnn.domain.repository;


import com.gestionAnn.domain.dto.ConsumidorDTO;

import java.util.List;
import java.util.Optional;

public interface ConsumidorRepository {
    List<ConsumidorDTO> findAll();
    Optional<ConsumidorDTO> findById(Long id);
    Optional<ConsumidorDTO> findByCorreo(String correo);
    ConsumidorDTO save(ConsumidorDTO consumidorDTO);
    ConsumidorDTO update(ConsumidorDTO consumidorDTO);
    void delete(Long id);
    boolean existsById(Long id);
    long count();
}
