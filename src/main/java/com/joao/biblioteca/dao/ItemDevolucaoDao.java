package com.joao.biblioteca.dao;

import java.util.List;

import com.joao.biblioteca.models.ItemDevolucao;

public interface ItemDevolucaoDao {
    public ItemDevolucao save(ItemDevolucao itemDevolucao);
    public ItemDevolucao findById(Long id);
    public ItemDevolucao findByLivroId(Long id);
    public List<ItemDevolucao> findAll();
}
