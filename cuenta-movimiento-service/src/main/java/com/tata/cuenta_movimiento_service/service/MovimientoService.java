package com.tata.cuenta_movimiento_service.service;

import com.tata.cuenta_movimiento_service.entity.Movimiento;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoService {
    List<Movimiento>listarMovimientos();
    List<Movimiento>obtenerMovimientosPorCuentaId(Integer cuentaId);
    List<Movimiento> reporteMovimientosPorClienteYFechas(Integer clienteId, LocalDate desde, LocalDate hasta);

    Movimiento buscarPorId(Integer id);
    @Transactional
    Movimiento crearMovimiento(Movimiento movimiento);
    void eliminarMovimiento(Integer id);
}
