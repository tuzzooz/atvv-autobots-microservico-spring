package com.autobots.automanager.entidades;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String numero;

    private String orgaoEmissor;
}
