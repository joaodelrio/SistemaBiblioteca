package com.joao.biblioteca.dao;

import java.util.List;

import com.joao.biblioteca.models.Titulo;

public interface TituloDao {
    Titulo save(Titulo titulo);
    Titulo findByIsbn(String isbn);
    List<Titulo> findAll();
}
