package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Cliente;

public interface clienteRepository extends CrudRepository<Cliente, Long> {

}
