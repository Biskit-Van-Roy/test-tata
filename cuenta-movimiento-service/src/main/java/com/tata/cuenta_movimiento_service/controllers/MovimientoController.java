package com.tata.cuenta_movimiento_service.controllers;

import com.tata.cuenta_movimiento_service.entity.Movimiento;
import com.tata.cuenta_movimiento_service.service.MovimientoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
/**
 * Controlador que gestiona todas las peticiones de consulta para la tabla movimientos
 * @author Roy Hidalgo royhidalgo1403@gmail.com
 * @version 1.0
 */
@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;
    @PostMapping
    public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento movimiento){
        return ResponseEntity.ok(movimientoService.crearMovimiento(movimiento));
    }
    @GetMapping
    public ResponseEntity<List<Movimiento>> listarMovimientos(){
        return ResponseEntity.ok(movimientoService.listarMovimientos());
    }
    @GetMapping("/por-cuenta")
    public ResponseEntity<List<Movimiento>> movimientosPorCuenta(@PathVariable Integer cuentaId){
        return ResponseEntity.ok(movimientoService.obtenerMovimientosPorCuentaId(cuentaId));
    }
    @GetMapping("/reporte")
    public ResponseEntity<List<Movimiento>> reportePorFechas(
            @RequestParam("desde") String desde,
            @RequestParam("hasta") String hasta,
            @RequestParam("clienteId") Integer clienteId
    ) {
        LocalDate fechaInicio = LocalDate.parse(desde);
        LocalDate fechaFin = LocalDate.parse(hasta);
        return ResponseEntity.ok(
                movimientoService.reporteMovimientosPorClienteYFechas(clienteId, fechaInicio, fechaFin)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        movimientoService.eliminarMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}
