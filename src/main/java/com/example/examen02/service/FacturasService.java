package com.example.examen02.service;

import java.util.List;
import java.util.Optional;

import com.example.examen02.entity.facturas;

public interface FacturasService {

    facturas create(facturas f);
    facturas update(facturas f);
    void delete(Long id);
    Optional<facturas> read(Long id);
    List<facturas> readAll();
}
