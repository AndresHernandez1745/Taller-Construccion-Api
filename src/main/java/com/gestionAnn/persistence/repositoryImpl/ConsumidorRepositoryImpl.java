package com.gestionAnn.persistence.repositoryImpl;

import com.gestionAnn.domain.dto.ConsumidorDTO;
import com.gestionAnn.domain.entity.Consumidor;
import com.gestionAnn.domain.repository.ConsumidorRepository;
import com.gestionAnn.persistence.crud.ConsumidorCrudRepository;
import com.gestionAnn.persistence.mapper.ConsumidorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ConsumidorRepositoryImpl implements ConsumidorRepository {

    @Autowired
    private ConsumidorCrudRepository consumidorCrudRepository;

    @Autowired
    private ConsumidorMapper consumidorMapper;

    @Override
    public List<ConsumidorDTO> findAll() {
        List<Consumidor> consumidores = (List<Consumidor>) consumidorCrudRepository.findAll();
        return consumidores.stream()
                .map(consumidorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ConsumidorDTO> findById(Long id) {
        return consumidorCrudRepository.findById(id)
                .map(consumidorMapper::toDto);
    }

    @Override
    public Optional<ConsumidorDTO> findByCorreo(String correo) {
        return consumidorCrudRepository.findByCorreo(correo)
                .map(consumidorMapper::toDto);
    }

    @Override
    public ConsumidorDTO save(ConsumidorDTO consumidorDTO) {
        Consumidor consumidor = consumidorMapper.toEntity(consumidorDTO);
        if (!existsById(consumidor.getId())) {
            Consumidor savedConsumidor = consumidorCrudRepository.save(consumidor);
            return consumidorMapper.toDto(savedConsumidor);
        }
        throw new IllegalArgumentException("El consumidor ya existe");
    }

    @Override
    public ConsumidorDTO update(ConsumidorDTO consumidorDTO) {
        Consumidor consumidor = consumidorMapper.toEntity(consumidorDTO);
        if (existsById(consumidor.getId())) {
            Consumidor updatedConsumidor = consumidorCrudRepository.save(consumidor);
            return consumidorMapper.toDto(updatedConsumidor);
        }
        throw new IllegalArgumentException("El consumidor no existe");
    }

    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            consumidorCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El consumidor no existe");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return consumidorCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return consumidorCrudRepository.count();
    }
}



