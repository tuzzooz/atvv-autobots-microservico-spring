package com.autobots.automanager.controles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {
    
    @Autowired
    private ClienteRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<Cliente>> obterTodos() {
        List<Cliente> clientes = repositorio.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Cliente>> obterPorEmpresa(@PathVariable Long empresaId) {
        List<Cliente> clientes = repositorio.findByEmpresaId(empresaId);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente novoCliente = repositorio.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cliente.setId(id);
        Cliente clienteAtualizado = repositorio.save(cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
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
