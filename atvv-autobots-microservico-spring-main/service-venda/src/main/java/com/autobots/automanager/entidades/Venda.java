package com.autobots.automanager.entidades;

import javax.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Long empresaId;

    @Column(nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private Long funcionarioId;

    private Long veiculoId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itens = new ArrayList<>();

    @Column(nullable = false)
    private Double total = 0.0;

    public void calcularTotal() {
        this.total = itens.stream()
            .mapToDouble(item -> item.getValor() * item.getQuantidade())
            .sum();
    }
}
