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

import com.joao.biblioteca.models.Livro;
import com.joao.biblioteca.models.Titulo;
import com.joao.biblioteca.repository.LivroRepository;
import com.joao.biblioteca.repository.TituloRepository;


@RestController
@RequestMapping("/livro")
public class LivroController {

    //Requisições http
    @Autowired
    private LivroRepository repository;

    @Autowired
    private TituloRepository tituloRepository;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        return ResponseEntity.ok(repository.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Livro> buscarPorIsbn(String isbn) {
        return ResponseEntity.ok(repository.findByIsbn(isbn));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable(value = "id")Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }


    // Metodos de negocio
    public Boolean verificaLivro(Long id){
        //Verifica se o livro já está cadastrado
        if (repository.findById(id) == null) {
            return false;
        }
        Livro livro = repository.findById(id);
        //Verifica se o livro está disponivel
        if(livro.getDisponivel() == false){
            return false;
        }
        //Verifica se é exemplar
        if(livro.getExemplarBiblioteca() == true){
            return false;
        }
        return true;
    }

    public Integer verPrazo(String isbn){
        Titulo titulo = tituloRepository.findByIsbn(isbn);
        return titulo.getPrazo();
        
    }

}
