package com.example.examen02.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen02.entity.carrito;
import com.example.examen02.repository.CarritoRepository;
import com.example.examen02.service.CarritoService;

@Service
public class CarritoServiceImpls implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public carrito create(carrito c) {
        return carritoRepository.save(c);
    }

    @Override
    public carrito update(carrito c) {
        return carritoRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public Optional<carrito> read(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public List<carrito> readAll() {
        return carritoRepository.findAll();
    }
}
