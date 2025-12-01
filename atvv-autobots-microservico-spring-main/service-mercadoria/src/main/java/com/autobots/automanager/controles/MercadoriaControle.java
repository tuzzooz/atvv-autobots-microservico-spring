package com.autobots.automanager.controles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.autobots.automanager.entidades.Mercadoria;
import com.autobots.automanager.repositorios.MercadoriaRepositorio;

@RestController
@RequestMapping("/mercadorias")
public class MercadoriaControle {
    
    @Autowired
    private MercadoriaRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<Mercadoria>> obterTodos() {
        List<Mercadoria> mercadorias = repositorio.findAll();
        return new ResponseEntity<>(mercadorias, HttpStatus.OK);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Mercadoria>> obterPorEmpresa(@PathVariable Long empresaId) {
        List<Mercadoria> mercadorias = repositorio.findByEmpresaId(empresaId);
        return new ResponseEntity<>(mercadorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mercadoria> obterPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .map(mercadoria -> new ResponseEntity<>(mercadoria, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Mercadoria> criar(@RequestBody Mercadoria mercadoria) {
        Mercadoria novaMercadoria = repositorio.save(mercadoria);
        return new ResponseEntity<>(novaMercadoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercadoria> atualizar(@PathVariable Long id, @RequestBody Mercadoria mercadoria) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mercadoria.setId(id);
        Mercadoria mercadoriaAtualizada = repositorio.save(mercadoria);
        return new ResponseEntity<>(mercadoriaAtualizada, HttpStatus.OK);
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
