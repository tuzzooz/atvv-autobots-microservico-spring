package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autobots.automanager.entidades.Funcionario;
import java.util.List;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByEmpresaId(Long empresaId);
}
