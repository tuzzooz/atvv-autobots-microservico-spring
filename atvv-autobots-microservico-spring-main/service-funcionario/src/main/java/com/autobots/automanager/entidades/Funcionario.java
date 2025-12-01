package com.autobots.automanager.entidades;

import javax.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String perfil;

    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(nullable = false)
    private Long empresaId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "funcionario_id")
    private List<Documento> documentos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "funcionario_id")
    private List<Telefone> telefones = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
}
