package com.sgb.bac.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(unique = true, nullable = false)
    private String numeroCuenta;

    @Column(nullable = false)
    private String tipoCuenta;

    @Column(nullable = false)
    private BigDecimal saldo = BigDecimal.ZERO;
}
