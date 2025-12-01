package com.autobots.automanager.entidades;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Long empresaId;
}
