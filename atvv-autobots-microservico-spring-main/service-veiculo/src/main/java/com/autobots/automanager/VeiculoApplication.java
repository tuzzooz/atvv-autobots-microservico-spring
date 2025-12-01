package com.autobots.automanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.autobots.automanager.entidades.Veiculo;
import com.autobots.automanager.repositorios.VeiculoRepositorio;

@SpringBootApplication
public class VeiculoApplication implements CommandLineRunner {
	
	@Autowired
	private VeiculoRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(VeiculoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar veículos de exemplo
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setModelo("Civic");
		veiculo1.setMarca("Honda");
		veiculo1.setPlaca("ABC-1234");
		veiculo1.setAno(2020);
		veiculo1.setClienteId(1L);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setModelo("Corolla");
		veiculo2.setMarca("Toyota");
		veiculo2.setPlaca("XYZ-5678");
		veiculo2.setAno(2019);
		veiculo2.setClienteId(1L);
		
		Veiculo veiculo3 = new Veiculo();
		veiculo3.setModelo("Onix");
		veiculo3.setMarca("Chevrolet");
		veiculo3.setPlaca("DEF-9012");
		veiculo3.setAno(2021);
		veiculo3.setClienteId(2L);
		
		Veiculo veiculo4 = new Veiculo();
		veiculo4.setModelo("HB20");
		veiculo4.setMarca("Hyundai");
		veiculo4.setPlaca("GHI-3456");
		veiculo4.setAno(2022);
		veiculo4.setClienteId(2L);
		
		repositorio.save(veiculo1);
		repositorio.save(veiculo2);
		repositorio.save(veiculo3);
		repositorio.save(veiculo4);
		
		System.out.println("=== Microserviço de Veículos Iniciado ===");
		System.out.println("Porta: 8085");
		System.out.println("Veículos cadastrados: " + repositorio.count());
	}
}
