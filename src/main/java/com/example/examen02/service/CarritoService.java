package com.example.examen02.service;

import java.util.List;
import java.util.Optional;

import com.example.examen02.entity.carrito;

public interface CarritoService {

    carrito create(carrito c);
    carrito update(carrito c);
    void delete(Long id);
    Optional<carrito> read(Long id);
    List<carrito> readAll();
}
