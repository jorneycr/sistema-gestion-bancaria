package com.sgb.bac.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoCliente;

    @Column(unique = true, nullable = false)
    private String tipo;

    @Column(nullable = false)
    private BigDecimal porcentajeComision;
}
