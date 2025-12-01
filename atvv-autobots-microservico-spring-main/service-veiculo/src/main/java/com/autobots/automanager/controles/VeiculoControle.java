package com.autobots.automanager.controles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.autobots.automanager.entidades.Veiculo;
import com.autobots.automanager.repositorios.VeiculoRepositorio;

@RestController
@RequestMapping("/veiculos")
public class VeiculoControle {
    
    @Autowired
    private VeiculoRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<Veiculo>> obterTodos() {
        List<Veiculo> veiculos = repositorio.findAll();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Veiculo>> obterPorCliente(@PathVariable Long clienteId) {
        List<Veiculo> veiculos = repositorio.findByClienteId(clienteId);
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> obterPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .map(veiculo -> new ResponseEntity<>(veiculo, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Veiculo> criar(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = repositorio.save(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        veiculo.setId(id);
        Veiculo veiculoAtualizado = repositorio.save(veiculo);
        return new ResponseEntity<>(veiculoAtualizado, HttpStatus.OK);
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
