package com.example.examen02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.examen02.entity.cliente;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Long> {

}
