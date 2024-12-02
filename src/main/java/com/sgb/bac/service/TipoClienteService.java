package com.sgb.bac.service;

import com.sgb.bac.entity.TipoCliente;
import com.sgb.bac.repository.TipoClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoClienteService {

    private final TipoClienteRepository tipoClienteRepository;

    public TipoClienteService(TipoClienteRepository tipoClienteRepository) {
        this.tipoClienteRepository = tipoClienteRepository;
    }

    public TipoCliente guardarTipoCliente(TipoCliente tipoCliente) {
        return tipoClienteRepository.save(tipoCliente);
    }
}
