package com.sgb.bac.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    @Column(nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_origen")
    private CuentaBancaria cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_destino")
    private CuentaBancaria cuentaDestino;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();
}
