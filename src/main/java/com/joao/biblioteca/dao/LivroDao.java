package com.joao.biblioteca.dao;

import java.util.List;

import com.joao.biblioteca.models.Livro;

public interface LivroDao {
    Livro save(Livro livro);
    Livro findByIsbn(String isbn);
    Livro findById(Long id);
    List<Livro> findAll();
}
