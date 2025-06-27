package com.tata.cliente_persona_service.service;

import com.tata.cliente_persona_service.entity.Cliente;
import com.tata.cliente_persona_service.entity.Persona;
import com.tata.cliente_persona_service.exception.ClienteNotFoundException;
import com.tata.cliente_persona_service.repository.ClienteRepository;
import com.tata.cliente_persona_service.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {
    @InjectMocks
    private ClienteServiceImpl clienteService;
    @Mock
    private ClienteRepository clienteRepository;
    private Cliente cliente;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        Persona persona = new Persona(1,"Roy Hidalgo", "Masculino", 29, "1724541741","Quito","0987654321");
        cliente = new Cliente(1,persona,"CTLI001","1234",true);
    }
    @Test
    void testBuscarClientePorId(){
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));
        Cliente resultado = clienteService.buscarPorId(1);
        assertNotNull(resultado);
        assertEquals("Roy Hidalgo", resultado.getPersona().getNombre());
    }
    @Test
    void testBuscarClientePorIdNoExiste(){
        when(clienteRepository.findById(15)).thenReturn(Optional.empty());
        assertThrows(ClienteNotFoundException.class,()->clienteService.buscarPorId(15));
    }

}
