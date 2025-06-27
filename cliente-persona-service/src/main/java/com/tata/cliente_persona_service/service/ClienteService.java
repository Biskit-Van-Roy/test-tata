package com.tata.cliente_persona_service.service;

import com.tata.cliente_persona_service.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);
    List<Cliente> listarClientes();
    Cliente actualizarCliente(Integer id, Cliente cliente);
    void eliminarCliente(Integer id);
    Cliente buscarPorId(Integer id);
}
