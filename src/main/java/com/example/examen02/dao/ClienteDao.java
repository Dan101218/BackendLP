package com.example.examen02.dao;

import java.util.List;
import java.util.Optional;

import com.example.examen02.entity.cliente;

public interface ClienteDao {
    cliente create(cliente c);
    cliente update(cliente c);
    void delete(Long id);
    Optional<cliente> read(Long id);
    List<cliente> readAll();
}
