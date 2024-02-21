package com.joao.biblioteca.decorator;

public class User implements Role{
    
    @Override
    public String getRole() {
        return "Aluno";
    }
}
