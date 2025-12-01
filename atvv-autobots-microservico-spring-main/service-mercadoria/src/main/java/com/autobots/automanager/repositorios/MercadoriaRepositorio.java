package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autobots.automanager.entidades.Mercadoria;
import java.util.List;

public interface MercadoriaRepositorio extends JpaRepository<Mercadoria, Long> {
    List<Mercadoria> findByEmpresaId(Long empresaId);
}
