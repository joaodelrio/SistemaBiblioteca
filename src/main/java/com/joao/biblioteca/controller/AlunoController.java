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

import com.joao.biblioteca.models.Aluno;
import com.joao.biblioteca.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    //Requisições http
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private DebitoController debitoController;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(repository.save(aluno));
    }
    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable(value = "matricula") int matricula) {
        return ResponseEntity.ok(repository.findById(matricula));
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    //Metodos de negocio
    public boolean verificaAluno(int matricula){
        Aluno aluno = repository.findById(matricula);
        if(aluno == null){
            return false;
        }
        return true;
    }
    public boolean verificaDebito(int matricula){
        return debitoController.verificarDebito(matricula);
    }

    // public boolean emprestar()
}
