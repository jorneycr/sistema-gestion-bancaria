package com.sgb.bac.controller;

import com.sgb.bac.entity.CuentaBancaria;
import com.sgb.bac.service.CuentaService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public List<CuentaBancaria> listarCuentas() {
        return cuentaService.listarCuentas();
    }

    @GetMapping("/{id}")
    public Optional<CuentaBancaria> obtenerCuenta(@PathVariable Long id) {
        return cuentaService.obtenerCuentaPorId(id);
    }

    @PostMapping
    public CuentaBancaria guardarCuenta(@RequestBody CuentaBancaria cuenta) {
        return cuentaService.guardarCuenta(cuenta);
    }

    @PostMapping("/{id}/deposito")
    public String depositar(@PathVariable Long id, @RequestParam BigDecimal monto) {
        return cuentaService.depositar(id, monto);
    }
}
