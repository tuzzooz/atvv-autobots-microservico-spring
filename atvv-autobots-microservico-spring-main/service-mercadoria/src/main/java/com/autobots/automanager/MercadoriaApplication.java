package com.autobots.automanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.autobots.automanager.entidades.Mercadoria;
import com.autobots.automanager.repositorios.MercadoriaRepositorio;

@SpringBootApplication
public class MercadoriaApplication implements CommandLineRunner {
	
	@Autowired
	private MercadoriaRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(MercadoriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar mercadorias de exemplo
		Mercadoria merc1 = new Mercadoria();
		merc1.setNome("Óleo Sintético 5W30");
		merc1.setDescricao("Óleo sintético premium para motores");
		merc1.setValor(85.00);
		merc1.setQuantidade(50);
		merc1.setEmpresaId(1L);
		
		Mercadoria merc2 = new Mercadoria();
		merc2.setNome("Filtro de Óleo");
		merc2.setDescricao("Filtro de óleo universal");
		merc2.setValor(25.00);
		merc2.setQuantidade(100);
		merc2.setEmpresaId(1L);
		
		Mercadoria merc3 = new Mercadoria();
		merc3.setNome("Pastilha de Freio");
		merc3.setDescricao("Jogo de pastilhas de freio dianteiras");
		merc3.setValor(120.00);
		merc3.setQuantidade(30);
		merc3.setEmpresaId(1L);
		
		Mercadoria merc4 = new Mercadoria();
		merc4.setNome("Bateria 60Ah");
		merc4.setDescricao("Bateria automotiva selada 60 amperes");
		merc4.setValor(380.00);
		merc4.setQuantidade(15);
		merc4.setEmpresaId(1L);
		
		Mercadoria merc5 = new Mercadoria();
		merc5.setNome("Pneu 185/65 R15");
		merc5.setDescricao("Pneu aro 15 para carros de passeio");
		merc5.setValor(320.00);
		merc5.setQuantidade(40);
		merc5.setEmpresaId(1L);
		
		repositorio.save(merc1);
		repositorio.save(merc2);
		repositorio.save(merc3);
		repositorio.save(merc4);
		repositorio.save(merc5);
		
		System.out.println("=== Microserviço de Mercadorias Iniciado ===");
		System.out.println("Porta: 8084");
		System.out.println("Mercadorias cadastradas: " + repositorio.count());
	}
}
