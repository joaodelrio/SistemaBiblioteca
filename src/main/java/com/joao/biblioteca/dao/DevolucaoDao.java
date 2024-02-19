package com.joao.biblioteca.dao;

import java.util.List;

import com.joao.biblioteca.models.Devolucao;

public interface DevolucaoDao {
    Devolucao save(Devolucao devolucao);
    Devolucao findById(Long id);
    Devolucao findByMatricula(int matricula);
    List<Devolucao> findAll();
}
