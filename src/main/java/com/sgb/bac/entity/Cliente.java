package com.sgb.bac.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String numeroIdentificacion;

    private String detallesContacto;
}
