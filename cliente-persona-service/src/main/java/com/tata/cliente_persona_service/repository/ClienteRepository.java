package com.tata.cliente_persona_service.repository;

import com.tata.cliente_persona_service.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByClienteId(String clienteId);
}
