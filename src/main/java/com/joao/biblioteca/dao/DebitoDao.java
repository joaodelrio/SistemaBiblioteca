package com.joao.biblioteca.dao;


import java.util.List;

import com.joao.biblioteca.models.Debito;

public interface DebitoDao {
    Debito save(Debito debito);
    Debito findById(Long id);
    Debito findByMatricula(int matricula);
    List<Debito> findAll();
}
