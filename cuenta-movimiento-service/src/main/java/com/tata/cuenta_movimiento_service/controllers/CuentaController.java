package com.tata.cuenta_movimiento_service.controllers;

import com.tata.cuenta_movimiento_service.entity.Cuenta;
import com.tata.cuenta_movimiento_service.service.CuentaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que gestiona todas las peticiones de consulta para la tabla cuentas
 * @author Roy Hidalgo royhidalgo1403@gmail.com
 * @version 1.0
 */
@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;
    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta){
        return ResponseEntity.ok(cuentaService.crearCuenta(cuenta));
    }
    @GetMapping
    public ResponseEntity<List<Cuenta>> listarCuentas(){
        return ResponseEntity.ok(cuentaService.listarCuentas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerPorId(@PathVariable Integer id){
        return ResponseEntity.ok(cuentaService.obtenerCuentaId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> editarCuenta(@PathVariable Integer id, @RequestBody Cuenta cuenta)
    {
        return ResponseEntity.ok(cuentaService.editarCuenta(id,cuenta));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Integer id){
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }
}
