package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autobots.automanager.entidades.Veiculo;
import java.util.List;

public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByClienteId(Long clienteId);
}
