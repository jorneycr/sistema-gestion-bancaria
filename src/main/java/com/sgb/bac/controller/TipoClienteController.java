package com.sgb.bac.controller;

import com.sgb.bac.entity.TipoCliente;
import com.sgb.bac.service.TipoClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipos-clientes")
public class TipoClienteController {

    private final TipoClienteService tipoClienteService;

    public TipoClienteController(TipoClienteService tipoClienteService) {
        this.tipoClienteService = tipoClienteService;
    }

    @PostMapping
    public TipoCliente agregarTipoCliente(@RequestBody TipoCliente tipoCliente) {
        return tipoClienteService.guardarTipoCliente(tipoCliente);
    }
}
