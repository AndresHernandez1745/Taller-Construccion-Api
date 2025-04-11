package com.gestionAnn.persistence.repositoryImpl;

import com.gestionAnn.domain.dto.PagoDTO;
import com.gestionAnn.domain.entity.Pago;
import com.gestionAnn.domain.repository.PagoRepository;
import com.gestionAnn.persistence.crud.PagoCrudRepository;
import com.gestionAnn.persistence.mapper.PagoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PagoRepositoryImpl implements PagoRepository {

    private final PagoCrudRepository pagoCrudRepository;
    private final PagoMapper pagoMapper;

    public PagoRepositoryImpl(PagoCrudRepository pagoCrudRepository, PagoMapper pagoMapper) {
        this.pagoCrudRepository = pagoCrudRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public List<PagoDTO> findAll() {
        return ((List<Pago>) pagoCrudRepository.findAll()).stream()
                .map(pagoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PagoDTO> findById(Long id) {
        return pagoCrudRepository.findById(id).map(pagoMapper::toDto);
    }

    @Override
    public PagoDTO save(PagoDTO pagoDTO) {
        Pago pago = pagoMapper.toEntity(pagoDTO);
        return pagoMapper.toDto(pagoCrudRepository.save(pago));
    }

    @Override
    public PagoDTO update(PagoDTO pagoDTO) {
        if (pagoCrudRepository.existsById(pagoDTO.getId())) {
            Pago pago = pagoMapper.toEntity(pagoDTO);
            return pagoMapper.toDto(pagoCrudRepository.save(pago));
        }
        throw new IllegalArgumentException("El pago no existe");
    }

    @Override
    public void delete(Long id) {
        pagoCrudRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return pagoCrudRepository.existsById(id);
    }
}
