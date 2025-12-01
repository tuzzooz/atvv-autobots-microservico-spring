package com.autobots.automanager.entidades;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo; // SERVICO ou MERCADORIA

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer quantidade;
}
