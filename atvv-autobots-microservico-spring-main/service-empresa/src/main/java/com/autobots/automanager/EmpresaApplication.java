package com.autobots.automanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.repositorios.EmpresaRepositorio;

@SpringBootApplication
public class EmpresaApplication implements CommandLineRunner {
	
	@Autowired
	private EmpresaRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar empresas de exemplo
		Empresa empresa1 = new Empresa();
		empresa1.setNomeFantasia("Auto Mecânica Silva");
		empresa1.setRazaoSocial("Auto Mecânica Silva LTDA");
		empresa1.setCnpj("11.222.333/0001-44");
		empresa1.setTelefone("(11) 3333-4444");
		empresa1.setEmail("contato@autosilva.com.br");
		
		Empresa empresa2 = new Empresa();
		empresa2.setNomeFantasia("Centro Automotivo Premium");
		empresa2.setRazaoSocial("Centro Automotivo Premium S.A.");
		empresa2.setCnpj("55.666.777/0001-88");
		empresa2.setTelefone("(11) 4444-5555");
		empresa2.setEmail("contato@autopremium.com.br");
		
		repositorio.save(empresa1);
		repositorio.save(empresa2);
		
		System.out.println("=== Microserviço de Empresas Iniciado ===");
		System.out.println("Porta: 8080");
		System.out.println("Empresas cadastradas: " + repositorio.count());
	}
}
