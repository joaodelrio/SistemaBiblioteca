package com.joao.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joao.biblioteca.dao.ItemEmprestimoDao;
import com.joao.biblioteca.models.ItemEmprestimo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ItemEmprestimoRepository implements ItemEmprestimoDao{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public ItemEmprestimo save(ItemEmprestimo itemEmprestimo) {
        entityManager.persist(itemEmprestimo);
        return itemEmprestimo;
    }

    @Override
    public ItemEmprestimo findById(Long id) {
        return entityManager.find(ItemEmprestimo.class, id);
    }

    @Override
    public List<ItemEmprestimo> findAll() {
        return entityManager.createQuery("SELECT a FROM item_emprestimo a", ItemEmprestimo.class).getResultList();
    }

}
