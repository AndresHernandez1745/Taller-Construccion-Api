package com.gestionAnn.persistence.repositoryImpl;

import com.gestionAnn.domain.dto.ReservaDTO;
import com.gestionAnn.domain.entity.Reserva;
import com.gestionAnn.domain.repository.ReservaRepository;
import com.gestionAnn.persistence.crud.ReservaCrudRepository;
import com.gestionAnn.persistence.mapper.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    @Override
    public List<ReservaDTO> findAll() {
        return ((List<Reserva>) reservaCrudRepository.findAll()).stream()
                .map(reservaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReservaDTO> findById(Long id) {
        return reservaCrudRepository.findById(id).map(reservaMapper::toDto);
    }

    @Override
    public ReservaDTO save(ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        return reservaMapper.toDto(reservaCrudRepository.save(reserva));
    }

    @Override
    public ReservaDTO update(ReservaDTO reservaDTO) {
        if (existsById(reservaDTO.getId())) {
            Reserva reserva = reservaMapper.toEntity(reservaDTO);
            return reservaMapper.toDto(reservaCrudRepository.save(reserva));
        }
        throw new IllegalArgumentException("La reserva no existe");
    }

    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            reservaCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("La reserva no existe");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return reservaCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return reservaCrudRepository.count();
    }
}

