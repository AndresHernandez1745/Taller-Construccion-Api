package com.gestionAnn.domain.service;

import com.gestionAnn.domain.dto.ConsumidorDTO;
import com.gestionAnn.domain.repository.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumidorService {

    @Autowired
    private ConsumidorRepository consumidorRepository;

    public List<ConsumidorDTO> obtenerTodos() {
        return consumidorRepository .findAll();
    }

    public Optional<ConsumidorDTO> obtenerPorId(Long id) {
        return consumidorRepository.findById(id);
    }

    public Optional<ConsumidorDTO> obtenerPorCorreo(String correo) {
        return consumidorRepository.findByCorreo(correo);
    }

    public ConsumidorDTO guardar(ConsumidorDTO consumidorDTO) {
        return consumidorRepository.save(consumidorDTO);
    }

    public ConsumidorDTO actualizar(ConsumidorDTO consumidorDTO) {
        return consumidorRepository.update(consumidorDTO);
    }

    public void eliminar(Long id) {
        consumidorRepository.delete(id);
    }

    public boolean existeCliente(Long id) {
        return consumidorRepository.existsById(id);
    }

    public long contarClientes() {
        return consumidorRepository.count();
    }
}
