package com.autobots.automanager.controles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.autobots.automanager.entidades.Servico;
import com.autobots.automanager.repositorios.ServicoRepositorio;

@RestController
@RequestMapping("/servicos")
public class ServicoControle {
    
    @Autowired
    private ServicoRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<Servico>> obterTodos() {
        List<Servico> servicos = repositorio.findAll();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Servico>> obterPorEmpresa(@PathVariable Long empresaId) {
        List<Servico> servicos = repositorio.findByEmpresaId(empresaId);
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> obterPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .map(servico -> new ResponseEntity<>(servico, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {
        Servico novoServico = repositorio.save(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody Servico servico) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servico.setId(id);
        Servico servicoAtualizado = repositorio.save(servico);
        return new ResponseEntity<>(servicoAtualizado, HttpStatus.OK);
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
