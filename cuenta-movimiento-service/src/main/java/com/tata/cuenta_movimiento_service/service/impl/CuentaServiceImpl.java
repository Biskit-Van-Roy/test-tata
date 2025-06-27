package com.tata.cuenta_movimiento_service.service.impl;

import com.tata.cuenta_movimiento_service.entity.Cuenta;
import com.tata.cuenta_movimiento_service.repository.CuentaRepository;
import com.tata.cuenta_movimiento_service.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    public List<Cuenta> listarCuentas(){
        return cuentaRepository.findAll();
    }


    @Override
    public Cuenta buscarPorId(Integer id){
        return cuentaRepository.findById(id).orElseThrow(()->new RuntimeException("Cuenta no encontrada con ID: "+id));
    }
    @Override
    public Cuenta crearCuenta(Cuenta cuenta){
        if(cuentaRepository.existsByNumeroCuenta(cuenta.getNumeroCuenta())){
            throw new RuntimeException("Ya existe una cuenta con ese numero");
        }
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta editarCuenta(Integer id, Cuenta cuenta) {
        return null;
    }

    @Override
    public Cuenta actualizarCuenta(Integer id, Cuenta nuevaCuenta) {
        Cuenta cuentaExistente = buscarPorId(id);

        cuentaExistente.setNumeroCuenta(nuevaCuenta.getNumeroCuenta());
        cuentaExistente.setTipoCuenta(nuevaCuenta.getTipoCuenta());
        cuentaExistente.setSaldoInicial(nuevaCuenta.getSaldoInicial());
        cuentaExistente.setEstado(nuevaCuenta.getEstado());

        return cuentaRepository.save(cuentaExistente);
    }

    @Override
    public void eliminarCuenta(Integer id) {
        if (!cuentaRepository.existsById(id)) {
            throw new RuntimeException("Cuenta no encontrada con ID: " + id);
        }
        cuentaRepository.deleteById(id);
    }

    @Override
    public Cuenta obtenerCuentaId(Integer id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con ID: " + id));
    }

}
