package com.autobots.automanager.controles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.repositorios.EmpresaRepositorio;

@RestController
@RequestMapping("/empresas")
public class EmpresaControle {
    
    @Autowired
    private EmpresaRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<Empresa>> obterTodas() {
        List<Empresa> empresas = repositorio.findAll();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obterPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .map(empresa -> new ResponseEntity<>(empresa, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = repositorio.save(empresa);
        return new ResponseEntity<>(novaEmpresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (!repositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        empresa.setId(id);
        Empresa empresaAtualizada = repositorio.save(empresa);
        return new ResponseEntity<>(empresaAtualizada, HttpStatus.OK);
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
