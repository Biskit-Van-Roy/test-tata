package com.tata.cuenta_movimiento_service.service.impl;

import com.tata.cuenta_movimiento_service.entity.Cuenta;
import com.tata.cuenta_movimiento_service.entity.Movimiento;
import com.tata.cuenta_movimiento_service.repository.CuentaRepository;
import com.tata.cuenta_movimiento_service.repository.MovimientoRepository;
import com.tata.cuenta_movimiento_service.service.MovimientoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    public List<Movimiento> listarMovimientos(){
        return movimientoRepository.findAll();
    }
    @Override
    public List<Movimiento> obtenerMovimientosPorCuentaId(Integer cuentaId) {
        return List.of();
    }

    @Override
    public List<Movimiento> reporteMovimientosPorClienteYFechas(Integer clienteId, LocalDate desde, LocalDate hasta) {
        LocalDateTime inicio = desde.atStartOfDay();
        LocalDateTime fin = hasta.atTime(23, 59, 59);
        return movimientoRepository.findByCuentaClienteIdAndFechaBetween(clienteId, inicio, fin);
    }


    @Override
    public Movimiento buscarPorId(Integer id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado con id: " + id));
    }
    @Transactional
    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuenta().getId())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        Double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();
        if (movimiento.getTipoMovimiento().equalsIgnoreCase("RETIRO") && nuevoSaldo < 0) {
            throw new RuntimeException("Saldo no disponible");
        }
        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);
        movimiento.setSaldo(nuevoSaldo);
        movimiento.setFecha(LocalDateTime.now());

        return movimientoRepository.save(movimiento);
    }
    @Override
    public void eliminarMovimiento(Integer id) {
        if (!movimientoRepository.existsById(id)) {
            throw new RuntimeException("Movimiento no encontrado con id: " + id);
        }
        movimientoRepository.deleteById(id);
    }




}
