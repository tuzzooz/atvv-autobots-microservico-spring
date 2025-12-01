package com.autobots.automanager.entidades;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false, unique = true)
    private String cnpj;

    private String nomeFantasia;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String email;
}
