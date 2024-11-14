package com.example.examen02.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examen02.dao.CarritoDao;
import com.example.examen02.entity.carrito;
import com.example.examen02.repository.CarritoRepository;

@Component
public class CarritoDaoImpls implements CarritoDao {

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
