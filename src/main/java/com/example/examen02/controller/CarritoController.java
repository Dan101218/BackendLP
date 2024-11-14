package com.example.examen02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.examen02.entity.carrito;
import com.example.examen02.serviceImpl.CarritoServiceImpls;

import jakarta.validation.Valid;

@RequestMapping("/api/carrito")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CarritoController {

    @Autowired
    private CarritoServiceImpls carritoServiceImpl;

    @GetMapping
    public ResponseEntity<List<carrito>> readAll() {
        try {
            List<carrito> carritos = carritoServiceImpl.readAll();

            if (carritos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(carritos, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<carrito> createCarrito(@Valid @RequestBody carrito c) {
        try {
            carrito nuevoCarrito = carritoServiceImpl.create(c);
            return new ResponseEntity<>(nuevoCarrito, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<carrito> updateCarrito(@PathVariable("id") Long id, @Valid @RequestBody carrito c) {
        Optional<carrito> carritoExistente = carritoServiceImpl.read(id);
        if (carritoExistente.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carritoServiceImpl.update(c), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<carrito> readCarrito(@PathVariable("id") Long id) {
        Optional<carrito> carrito = carritoServiceImpl.read(id);
        return carrito.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCarrito(@PathVariable("id") Long id) {
        try {
            carritoServiceImpl.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
