package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autobots.automanager.entidades.Servico;
import java.util.List;

public interface ServicoRepositorio extends JpaRepository<Servico, Long> {
    List<Servico> findByEmpresaId(Long empresaId);
}
