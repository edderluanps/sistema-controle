package com.eluanps.sistemacontrole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eluanps.sistemacontrole.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
