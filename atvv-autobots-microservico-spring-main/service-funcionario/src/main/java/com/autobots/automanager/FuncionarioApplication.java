package com.autobots.automanager;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.autobots.automanager.entidades.Funcionario;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.repositorios.FuncionarioRepositorio;

@SpringBootApplication
public class FuncionarioApplication implements CommandLineRunner {
	
	@Autowired
	private FuncionarioRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar funcionários de exemplo
		Funcionario func1 = new Funcionario();
		func1.setNome("Carlos Souza");
		func1.setEmail("carlos.souza@automanager.com");
		func1.setPerfil("Gerente");
		func1.setDataAdmissao(new Date());
		func1.setEmpresaId(1L);
		
		Documento doc1 = new Documento();
		doc1.setTipo("CPF");
		doc1.setNumero("111.222.333-44");
		doc1.setOrgaoEmissor("SSP-SP");
		func1.getDocumentos().add(doc1);
		
		Telefone tel1 = new Telefone();
		tel1.setDdd("11");
		tel1.setNumero("91111-2222");
		tel1.setTipo("Celular");
		func1.getTelefones().add(tel1);
		
		Endereco end1 = new Endereco();
		end1.setEstado("SP");
		end1.setCidade("São Paulo");
		end1.setBairro("Vila Mariana");
		end1.setRua("Rua Domingos de Morais");
		end1.setNumero("2000");
		end1.setCep("04035-000");
		func1.setEndereco(end1);
		
		Funcionario func2 = new Funcionario();
		func2.setNome("Ana Costa");
		func2.setEmail("ana.costa@automanager.com");
		func2.setPerfil("Mecânico");
		func2.setDataAdmissao(new Date());
		func2.setEmpresaId(1L);
		
		Documento doc2 = new Documento();
		doc2.setTipo("CPF");
		doc2.setNumero("555.666.777-88");
		doc2.setOrgaoEmissor("SSP-SP");
		func2.getDocumentos().add(doc2);
		
		Telefone tel2 = new Telefone();
		tel2.setDdd("11");
		tel2.setNumero("92222-3333");
		tel2.setTipo("Celular");
		func2.getTelefones().add(tel2);
		
		Endereco end2 = new Endereco();
		end2.setEstado("SP");
		end2.setCidade("São Paulo");
		end2.setBairro("Moema");
		end2.setRua("Av. Ibirapuera");
		end2.setNumero("3000");
		end2.setCep("04029-200");
		func2.setEndereco(end2);
		
		repositorio.save(func1);
		repositorio.save(func2);
		
		System.out.println("=== Microserviço de Funcionários Iniciado ===");
		System.out.println("Porta: 8082");
		System.out.println("Funcionários cadastrados: " + repositorio.count());
	}
}
