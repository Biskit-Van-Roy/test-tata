package com.tata.cuenta_movimiento_service.service;

import com.tata.cuenta_movimiento_service.entity.Cuenta;
import com.tata.cuenta_movimiento_service.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CuentaService {
    Cuenta buscarPorId(Integer id);
    Cuenta crearCuenta(Cuenta cuenta);
    Cuenta editarCuenta(Integer id, Cuenta cuenta);
    Cuenta actualizarCuenta(Integer id, Cuenta nuevaCuenta);
    void eliminarCuenta(Integer id);
    Cuenta obtenerCuentaId(Integer id);
    List<Cuenta> listarCuentas();

}
