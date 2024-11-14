package com.example.examen02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.examen02.entity.cliente;
import com.example.examen02.serviceImpl.ClienteServiceImpls;

import jakarta.validation.Valid;

@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ClienteController {

    @Autowired
    private ClienteServiceImpls clienteServiceImpl;

    @GetMapping
    public ResponseEntity<List<cliente>> readAll() {
        try {
            List<cliente> clientes = clienteServiceImpl.readAll();

            if (clientes.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(clientes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<cliente> createCliente(@Valid @RequestBody cliente c) {
        try {
            cliente nuevoCliente = clienteServiceImpl.create(c);
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<cliente> updateCliente(@PathVariable("id") Long id, @Valid @RequestBody cliente c) {
        Optional<cliente> clienteExistente = clienteServiceImpl.read(id);
        if (clienteExistente.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteServiceImpl.update(c), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<cliente> readCliente(@PathVariable("id") Long id) {
        Optional<cliente> cliente = clienteServiceImpl.read(id);
        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") Long id) {
        try {
            clienteServiceImpl.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
