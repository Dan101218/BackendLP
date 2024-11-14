package com.example.examen02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.examen02.entity.facturas;
import com.example.examen02.serviceImpl.FacturasServiceImpls;

import jakarta.validation.Valid;

@RequestMapping("/api/facturas")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class FacturaController {

    @Autowired
    private FacturasServiceImpls facturasServiceImpl;

    @GetMapping
    public ResponseEntity<List<facturas>> readAll() {
        try {
            List<facturas> facturasList = facturasServiceImpl.readAll();

            if (facturasList.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(facturasList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<facturas> createFactura(@Valid @RequestBody facturas f) {
        try {
            facturas nuevaFactura = facturasServiceImpl.create(f);
            return new ResponseEntity<>(nuevaFactura, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<facturas> updateFactura(@PathVariable("id") Long id, @Valid @RequestBody facturas f) {
        Optional<facturas> facturaExistente = facturasServiceImpl.read(id);
        if (facturaExistente.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facturasServiceImpl.update(f), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<facturas> readFactura(@PathVariable("id") Long id) {
        Optional<facturas> factura = facturasServiceImpl.read(id);
        return factura.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFactura(@PathVariable("id") Long id) {
        try {
            facturasServiceImpl.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
