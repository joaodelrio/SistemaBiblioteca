package com.joao.biblioteca.dao;

import java.util.List;

import com.joao.biblioteca.models.Autor;

public interface AutorDao {
    Autor save(Autor autor);
    Autor findById(Long id);
    List<Autor> findAll();
}
