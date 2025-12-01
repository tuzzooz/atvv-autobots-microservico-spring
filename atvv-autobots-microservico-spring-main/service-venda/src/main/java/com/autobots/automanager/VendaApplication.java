package com.autobots.automanager;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.autobots.automanager.entidades.Venda;
import com.autobots.automanager.entidades.ItemVenda;
import com.autobots.automanager.repositorios.VendaRepositorio;

@SpringBootApplication
public class VendaApplication implements CommandLineRunner {
	
	@Autowired
	private VendaRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(VendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar vendas de exemplo
		Venda venda1 = new Venda();
		venda1.setData(new Date());
		venda1.setEmpresaId(1L);
		venda1.setClienteId(1L);
		venda1.setFuncionarioId(1L);
		venda1.setVeiculoId(1L);
		
		ItemVenda item1 = new ItemVenda();
		item1.setTipo("SERVICO");
		item1.setItemId(1L);
		item1.setNome("Troca de Óleo");
		item1.setValor(150.00);
		item1.setQuantidade(1);
		venda1.getItens().add(item1);
		
		ItemVenda item2 = new ItemVenda();
		item2.setTipo("MERCADORIA");
		item2.setItemId(1L);
		item2.setNome("Óleo Sintético 5W30");
		item2.setValor(85.00);
		item2.setQuantidade(1);
		venda1.getItens().add(item2);
		
		venda1.calcularTotal();
		
		Venda venda2 = new Venda();
		venda2.setData(new Date());
		venda2.setEmpresaId(1L);
		venda2.setClienteId(2L);
		venda2.setFuncionarioId(2L);
		venda2.setVeiculoId(3L);
		
		ItemVenda item3 = new ItemVenda();
		item3.setTipo("SERVICO");
		item3.setItemId(2L);
		item3.setNome("Alinhamento e Balanceamento");
		item3.setValor(120.00);
		item3.setQuantidade(1);
		venda2.getItens().add(item3);
		
		venda2.calcularTotal();
		
		repositorio.save(venda1);
		repositorio.save(venda2);
		
		System.out.println("=== Microserviço de Vendas Iniciado ===");
		System.out.println("Porta: 8086");
		System.out.println("Vendas cadastradas: " + repositorio.count());
	}
}
