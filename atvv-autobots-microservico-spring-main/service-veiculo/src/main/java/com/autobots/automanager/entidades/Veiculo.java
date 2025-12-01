package com.autobots.automanager.entidades;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Long clienteId;
}
