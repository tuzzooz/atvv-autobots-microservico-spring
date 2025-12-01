package com.autobots.automanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.autobots.automanager.entidades.Servico;
import com.autobots.automanager.repositorios.ServicoRepositorio;

@SpringBootApplication
public class ServicoApplication implements CommandLineRunner {
	
	@Autowired
	private ServicoRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ServicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar serviços de exemplo
		Servico servico1 = new Servico();
		servico1.setNome("Troca de Óleo");
		servico1.setDescricao("Troca de óleo do motor com filtro");
		servico1.setValor(150.00);
		servico1.setEmpresaId(1L);
		
		Servico servico2 = new Servico();
		servico2.setNome("Alinhamento e Balanceamento");
		servico2.setDescricao("Alinhamento e balanceamento das 4 rodas");
		servico2.setValor(120.00);
		servico2.setEmpresaId(1L);
		
		Servico servico3 = new Servico();
		servico3.setNome("Revisão Completa");
		servico3.setDescricao("Revisão preventiva com checklist completo");
		servico3.setValor(450.00);
		servico3.setEmpresaId(1L);
		
		Servico servico4 = new Servico();
		servico4.setNome("Troca de Pastilhas de Freio");
		servico4.setDescricao("Troca de pastilhas de freio dianteiras");
		servico4.setValor(280.00);
		servico4.setEmpresaId(1L);
		
		repositorio.save(servico1);
		repositorio.save(servico2);
		repositorio.save(servico3);
		repositorio.save(servico4);
		
		System.out.println("=== Microserviço de Serviços Iniciado ===");
		System.out.println("Porta: 8083");
		System.out.println("Serviços cadastrados: " + repositorio.count());
	}
}
