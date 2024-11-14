package com.example.examen02.service;

import java.util.List;
import java.util.Optional;

import com.example.examen02.entity.cliente;

public interface ClienteService {

    cliente create(cliente c);
    cliente update(cliente c);
    void delete(Long id);
    Optional<cliente> read(Long id);
    List<cliente> readAll();
}
