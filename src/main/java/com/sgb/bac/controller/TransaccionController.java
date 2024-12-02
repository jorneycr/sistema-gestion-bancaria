package com.sgb.bac.controller;

import com.sgb.bac.entity.Transaccion;
import com.sgb.bac.service.TransaccionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping("/transferencia")
    public String transferirFondos(@RequestParam Long cuentaOrigen,
                                   @RequestParam Long cuentaDestino,
                                   @RequestParam BigDecimal monto) {
        return transaccionService.transferirFondos(cuentaOrigen, cuentaDestino, monto);
    }

    @GetMapping("/historial/{idCuenta}")
    public List<Transaccion> obtenerHistorial(@PathVariable Long idCuenta) {
        return transaccionService.obtenerHistorialTransacciones(idCuenta);
    }
}
