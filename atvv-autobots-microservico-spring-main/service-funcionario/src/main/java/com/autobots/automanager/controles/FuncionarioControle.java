package com.autobots.automanager.controles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.autobots.automanager.entidades.Funcionario;
import com.autobots.automanager.repositorios.FuncionarioRepositorio;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioControle {
    
    @Autowired
    private FuncionarioRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<Funcionario>> obterTodos() {
        List<Funcionario> funcionarios = repositorio.findAll();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Funcionario>> obterPorEmpresa(@PathVariable Long empresaId) {
        List<Funcionario> funcionarios = repositorio.findByEmpresaId(empresaId);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> obterPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .map(funcionario -> new ResponseEntity<>(funcionario, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = repositorio.save(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        funcionario.setId(id);
        Funcionario funcionarioAtualizado = repositorio.save(funcionario);
        return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
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
