package com.gestionAnn.domain.repository;

import com.gestionAnn.domain.dto.ViajeDTO;

import java.util.List;
import java.util.Optional;

public interface ViajeRepository {
    List<ViajeDTO> findAll();
    Optional<ViajeDTO> findById(Long id);
    ViajeDTO save(ViajeDTO viajeDTO);
    ViajeDTO update(ViajeDTO viajeDTO);
    void delete(Long id);
    long count();
    boolean existsById(Long id);
}
