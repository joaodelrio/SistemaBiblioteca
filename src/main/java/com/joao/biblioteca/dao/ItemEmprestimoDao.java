package com.joao.biblioteca.dao;

import java.util.List;

import com.joao.biblioteca.models.ItemEmprestimo;

public interface ItemEmprestimoDao {
    public ItemEmprestimo save(ItemEmprestimo itemEmprestimo);
    public ItemEmprestimo findById(Long id);
    public ItemEmprestimo findByLivroId(Long id);
    public List<ItemEmprestimo> findAll();
}
