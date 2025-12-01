package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.autobots.automanager.entidades.Venda;
import java.util.Date;
import java.util.List;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {
    List<Venda> findByEmpresaId(Long empresaId);
    
    @Query("SELECT v FROM Venda v WHERE v.empresaId = :empresaId AND v.data BETWEEN :inicio AND :fim")
    List<Venda> findByEmpresaIdAndDataBetween(
        @Param("empresaId") Long empresaId, 
        @Param("inicio") Date inicio, 
        @Param("fim") Date fim
    );
}
