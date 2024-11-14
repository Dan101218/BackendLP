package com.example.examen02.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examen02.dao.FacturasDao;
import com.example.examen02.entity.facturas;
import com.example.examen02.repository.FacturasRepository;

@Component
public class FacturasDaoImpls implements FacturasDao {

    @Autowired
    private FacturasRepository facturasRepository;

    @Override
    public facturas create(facturas f) {
        return facturasRepository.save(f);
    }

    @Override
    public facturas update(facturas f) {
        return facturasRepository.save(f);
    }

    @Override
    public void delete(Long id) {
        facturasRepository.deleteById(id);
    }

    @Override
    public Optional<facturas> read(Long id) {
        return facturasRepository.findById(id);
    }

    @Override
    public List<facturas> readAll() {
        return facturasRepository.findAll();
    }
}
