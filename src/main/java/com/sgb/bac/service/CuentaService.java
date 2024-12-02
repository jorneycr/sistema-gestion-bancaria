package com.sgb.bac.service;

import com.sgb.bac.entity.CuentaBancaria;
import com.sgb.bac.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<CuentaBancaria> listarCuentas() {
        return cuentaRepository.findAll();
    }

    public Optional<CuentaBancaria> obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    public CuentaBancaria guardarCuenta(CuentaBancaria cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    public String depositar(Long idCuenta, BigDecimal monto) {
        Optional<CuentaBancaria> cuentaOpt = cuentaRepository.findById(idCuenta);

        if (cuentaOpt.isEmpty()) {
            return "Cuenta no encontrada.";
        }

        CuentaBancaria cuenta = cuentaOpt.get();
        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        cuentaRepository.save(cuenta);

        return "Depósito realizado con éxito.";
    }
}
