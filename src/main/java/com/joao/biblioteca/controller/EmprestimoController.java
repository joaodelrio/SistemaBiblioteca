package com.joao.biblioteca.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.joao.biblioteca.models.Emprestimo;
import com.joao.biblioteca.models.ItemEmprestimo;
import com.joao.biblioteca.models.Livro;
import com.joao.biblioteca.repository.EmprestimoRepository;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository repository;

    //Requisições http
    @PostMapping
    public ResponseEntity<Emprestimo> cadastrarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return ResponseEntity.ok(repository.save(emprestimo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @GetMapping("aluno/{matricula}")
    public ResponseEntity<Emprestimo> buscarPorMatricula(@PathVariable(value = "matricula") int matricula) {
        return ResponseEntity.ok(repository.findByMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    //Métodos de negócio
    // public boolean emprestarLivro(int matricula, List<String> livrosIsbn){
    //     boolean retorno=true;
    //     AlunoController alunoController = new AlunoController();
    //     //Verifica se o aluno está cadastrado
    //     if(!alunoController.verificaAluno(matricula)){
    //         System.out.println("Aluno não cadastrado");
    //         retorno = false;
    //     }
        
    //     //Verifica se o aluno tem débito
    //     if(!alunoController.verificaDebito(matricula)){
    //         System.out.println("Aluno com débito");
    //         retorno = false;
            
    //     }
    //     //Cria um emprestimo
    //     Emprestimo emprestimo = new Emprestimo();
    //     List<Livro> livros  = new ArrayList<Livro>();
    //     //Para cada livro
    //     for (String livro : livrosIsbn) {
    //         LivroController livroController = new LivroController();
    //         //Verifica se o livro pode ser emprestado
    //         if(livroController.verificaLivro(livro)){
    //             Livro livroAux = livroController.buscarPorIsbn(livro).getBody();
    //             livros.add(livroAux);
    //         }
    //     }
    //     return retorno;
    
    // }
        

    // public Date calculaDataDevolucao(){
    //     Emprestimo.getItemEmprestimo();
    // }
}
