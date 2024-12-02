package com.sgb.bac.service;

import com.sgb.bac.entity.CuentaBancaria;
import com.sgb.bac.entity.Transaccion;
import com.sgb.bac.repository.CuentaRepository;
import com.sgb.bac.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public TransaccionService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    @Transactional
    public String transferirFondos(Long idCuentaOrigen, Long idCuentaDestino, BigDecimal monto) {
        Optional<CuentaBancaria> cuentaOrigenOpt = cuentaRepository.findById(idCuentaOrigen);
        Optional<CuentaBancaria> cuentaDestinoOpt = cuentaRepository.findById(idCuentaDestino);

        if (cuentaOrigenOpt.isEmpty() || cuentaDestinoOpt.isEmpty()) {
            return "Cuenta no encontrada.";
        }

        CuentaBancaria cuentaOrigen = cuentaOrigenOpt.get();
        CuentaBancaria cuentaDestino = cuentaDestinoOpt.get();

        if (cuentaOrigen.getSaldo().compareTo(monto) < 0) {
            return "Saldo insuficiente.";
        }

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(monto));
        cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(monto));

        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);

        Transaccion transaccion = new Transaccion();
        transaccion.setTipo("Transferencia");
        transaccion.setCuentaOrigen(cuentaOrigen);
        transaccion.setCuentaDestino(cuentaDestino);
        transaccion.setMonto(monto);

        transaccion.calcularComision();

        transaccionRepository.save(transaccion);

        return "Transferencia realizada con éxito.";
    }

    public List<Transaccion> obtenerHistorialTransacciones(Long idCuenta) {
        return transaccionRepository.findByCuentaOrigen_IdCuentaOrCuentaDestino_IdCuenta(idCuenta, idCuenta);
    }
}
