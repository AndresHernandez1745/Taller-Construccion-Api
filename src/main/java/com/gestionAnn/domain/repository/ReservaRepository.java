package com.gestionAnn.domain.repository;

import com.gestionAnn.domain.dto.ReservaDTO;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    List<ReservaDTO> findAll();
    Optional<ReservaDTO> findById(Long id);
    ReservaDTO save(ReservaDTO reservaDTO);
    ReservaDTO update(ReservaDTO reservaDTO);
    void delete(Long id);
    boolean existsById(Long id);
    long count();
}

