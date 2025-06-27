package com.tata.cliente_persona_service.controllers;

import com.tata.cliente_persona_service.entity.Cliente;
import com.tata.cliente_persona_service.service.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que gestiona todas las peticiones de consulta para la tabla clientes
 * @author Roy Hidalgo royhidalgo1403@gmail.com
 * @version 1.0
 */
@RestController
@RequestMapping("/api/clientes")
public class ClientePersonaController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Metodo que crea un cliente en la base de datos
     * @author Roy Hidalgo
     * @param cliente
     * @return El cliente creado
     */
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }

    /**
     * Metodo que retorna la lista de los clientes en la base de datos
     * @author Roy Hidalgo
     * @return Lista de los clientes
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    /**
     * Metodo que retorna un cliente en especifico basado en el id
     * @param id
     * @return Cliente en especifico
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    /**
     * Metodo que actualiza un cliente especifico basado en su id
     * @param id
     * @param clienteActualizado
     * @return Retorna el cliente actualizado en Json
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente clienteActualizado) {
        Cliente actualizado = clienteService.actualizarCliente(id, clienteActualizado);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * Metodo que borra un cliente especifico basado en su id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }


}
