package com.joao.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.biblioteca.models.Devolucao;
import com.joao.biblioteca.repository.DevolucaoRepository;

@RestController
@RequestMapping("/devolucao")
public class DevolucaoController {
    @Autowired
    private DevolucaoRepository repository;

    //Requisições http
    @PostMapping
    public ResponseEntity<Devolucao> cadastrarDevolucao(@RequestBody Devolucao devolucao) {
        return ResponseEntity.ok(repository.save(devolucao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devolucao> buscarPorId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @GetMapping("aluno/{matricula}")
    public ResponseEntity<Devolucao> buscarPorMatricula(@PathVariable(value = "matricula") int matricula) {
        return ResponseEntity.ok(repository.findByMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Devolucao>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }
}
