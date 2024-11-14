package com.example.examen02.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examen02.dao.ClienteDao;
import com.example.examen02.entity.cliente;
import com.example.examen02.repository.ClienteRepository;

@Component
public class ClienteDaoImpls implements ClienteDao {

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
