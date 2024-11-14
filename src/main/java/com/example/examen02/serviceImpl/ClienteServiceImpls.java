package com.example.examen02.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen02.entity.cliente;
import com.example.examen02.repository.ClienteRepository;
import com.example.examen02.service.ClienteService;

@Service
public class ClienteServiceImpls implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public cliente create(cliente c) {
        return clienteRepository.save(c);
    }

    @Override
    public cliente update(cliente c) {
        return clienteRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<cliente> read(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<cliente> readAll() {
        return clienteRepository.findAll();
    }
}
