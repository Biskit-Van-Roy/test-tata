package com.tata.cuenta_movimiento_service.repository;

import com.tata.cuenta_movimiento_service.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    List<Movimiento> findByCuentaId(Integer cuentaId);

    List<Movimiento> findByFechaBetween(LocalDateTime desde, LocalDateTime hasta);

    List<Movimiento> findByCuentaClienteIdAndFechaBetween(Integer clienteId, LocalDateTime desde, LocalDateTime hasta);
}
