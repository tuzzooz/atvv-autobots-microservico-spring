package com.autobots.automanager;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@SpringBootApplication
public class ClienteApplication implements CommandLineRunner {
	
	@Autowired
	private ClienteRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar clientes de exemplo
		Cliente cliente1 = new Cliente();
		cliente1.setNome("João Silva");
		cliente1.setEmail("joao.silva@email.com");
		cliente1.setDataCadastro(new Date());
		cliente1.setEmpresaId(1L);
		
		Documento doc1 = new Documento();
		doc1.setTipo("CPF");
		doc1.setNumero("123.456.789-00");
		doc1.setOrgaoEmissor("SSP-SP");
		cliente1.getDocumentos().add(doc1);
		
		Telefone tel1 = new Telefone();
		tel1.setDdd("11");
		tel1.setNumero("98765-4321");
		tel1.setTipo("Celular");
		cliente1.getTelefones().add(tel1);
		
		Endereco end1 = new Endereco();
		end1.setEstado("SP");
		end1.setCidade("São Paulo");
		end1.setBairro("Centro");
		end1.setRua("Av. Paulista");
		end1.setNumero("1000");
		end1.setCep("01310-100");
		cliente1.setEndereco(end1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Maria Santos");
		cliente2.setEmail("maria.santos@email.com");
		cliente2.setDataCadastro(new Date());
		cliente2.setEmpresaId(1L);
		
		Documento doc2 = new Documento();
		doc2.setTipo("CPF");
		doc2.setNumero("987.654.321-00");
		doc2.setOrgaoEmissor("SSP-RJ");
		cliente2.getDocumentos().add(doc2);
		
		Telefone tel2 = new Telefone();
		tel2.setDdd("21");
		tel2.setNumero("91234-5678");
		tel2.setTipo("Celular");
		cliente2.getTelefones().add(tel2);
		
		Endereco end2 = new Endereco();
		end2.setEstado("RJ");
		end2.setCidade("Rio de Janeiro");
		end2.setBairro("Copacabana");
		end2.setRua("Av. Atlântica");
		end2.setNumero("500");
		end2.setCep("22070-000");
		cliente2.setEndereco(end2);
		
		repositorio.save(cliente1);
		repositorio.save(cliente2);
		
		System.out.println("=== Microserviço de Clientes Iniciado ===");
		System.out.println("Porta: 8081");
		System.out.println("Clientes cadastrados: " + repositorio.count());
	}
}
