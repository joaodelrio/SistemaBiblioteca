package com.joao.biblioteca.decorator;

public class Admin implements Role{
    
    @Override
    public String getRole() {
        return "Admin";
    }
}
