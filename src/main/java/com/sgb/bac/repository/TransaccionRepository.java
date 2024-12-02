package com.sgb.bac.repository;

import com.sgb.bac.entity.Transaccion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCuentaOrigen_IdCuentaOrCuentaDestino_IdCuenta(Long idCuenta, Long idCuenta2);
}

