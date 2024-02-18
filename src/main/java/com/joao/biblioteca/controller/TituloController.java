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

import com.joao.biblioteca.models.Autor;
import com.joao.biblioteca.models.Titulo;
import com.joao.biblioteca.repository.AutorRepository;
import com.joao.biblioteca.repository.TituloRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/titulo")
public class TituloController {
    
    //Requisições http
    @Autowired
    private TituloRepository repository;
    @Autowired
    private AutorRepository autorRepository;
    @PostMapping
    public ResponseEntity<Titulo> cadastrarTitulo(@RequestBody Titulo titulo) {
        return ResponseEntity.ok(repository.save(titulo));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Titulo> encontrarPorIsbn(@PathVariable(value = "isbn") String isbn) {
        return ResponseEntity.ok(repository.findByIsbn(isbn));
    }
    @GetMapping
    public ResponseEntity<List<Titulo>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{isbn}/autor/{id}")
    public ResponseEntity<Titulo> adicionarAutor(
        @PathVariable(value = "isbn") String isbn, 
        @PathVariable(value = "id") Long id) {
        Titulo titulo = repository.findByIsbn(isbn);
        System.out.println(titulo);
        Autor autor = autorRepository.findById(id);
        System.out.println(autor);
        titulo.getAutores().add(autor);
        return ResponseEntity.ok(repository.save(titulo));
    }

    public Integer verPrazo(String isbn){
        Titulo titulo = repository.findByIsbn(isbn);
        return titulo.getPrazo();
    }

}
