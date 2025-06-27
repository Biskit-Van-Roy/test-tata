package com.tata.cliente_persona_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tata.cliente_persona_service.entity.Cliente;
import com.tata.cliente_persona_service.entity.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // ✅ correcto
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientePersonaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearYListarCliente() throws Exception {
        Persona persona = new Persona(null, "Roy Hidalgo", "Masculino", 29, "ID991", "Colinas del Pichincha", "0987654321");
        Cliente cliente = new Cliente(null, persona, "CLI000", "qwe123", true);
        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId").value("CLI000"));

        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.clienteId == 'CLI000')]").exists());
    }
}
