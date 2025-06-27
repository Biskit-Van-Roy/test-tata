package com.tata.cliente_persona_service.service.impl;

import com.tata.cliente_persona_service.entity.Cliente;
import com.tata.cliente_persona_service.exception.ClienteNotFoundException;
import com.tata.cliente_persona_service.repository.ClienteRepository;
import com.tata.cliente_persona_service.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @Override
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
    @Override
    public Cliente actualizarCliente(Integer id, Cliente clienteActualizado) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Optional<Cliente> duplicado = clienteRepository.findByClienteId(clienteActualizado.getClienteId());
        if (duplicado.isPresent() && !duplicado.get().getId().equals(id)) {
            throw new RuntimeException("El clienteId ya está en uso por otro cliente.");
        }
        existente.setClienteId(clienteActualizado.getClienteId());
        existente.setEstado(clienteActualizado.getEstado());
        existente.setPassword(clienteActualizado.getPassword());
        existente.setPersona(clienteActualizado.getPersona());

        return clienteRepository.save(existente);
    }

    @Override
    public void eliminarCliente(Integer id){
        clienteRepository.deleteById(id);
    }
    @Override
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado con id: " + id));
    }
}
