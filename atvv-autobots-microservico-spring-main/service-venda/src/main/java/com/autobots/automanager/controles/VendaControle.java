package com.autobots.automanager.controles;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.autobots.automanager.entidades.Venda;
import com.autobots.automanager.repositorios.VendaRepositorio;

@RestController
@RequestMapping("/vendas")
public class VendaControle {
    
    @Autowired
    private VendaRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<Venda>> obterTodos() {
        List<Venda> vendas = repositorio.findAll();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Venda>> obterPorEmpresa(@PathVariable Long empresaId) {
        List<Venda> vendas = repositorio.findByEmpresaId(empresaId);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/empresa/{empresaId}/periodo")
    public ResponseEntity<List<Venda>> obterPorEmpresaPeriodo(
            @PathVariable Long empresaId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fim) {
        List<Venda> vendas = repositorio.findByEmpresaIdAndDataBetween(empresaId, inicio, fim);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> obterPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .map(venda -> new ResponseEntity<>(venda, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Venda> criar(@RequestBody Venda venda) {
        venda.calcularTotal();
        Venda novaVenda = repositorio.save(venda);
        return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@PathVariable Long id, @RequestBody Venda venda) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        venda.setId(id);
        venda.calcularTotal();
        Venda vendaAtualizada = repositorio.save(venda);
        return new ResponseEntity<>(vendaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
