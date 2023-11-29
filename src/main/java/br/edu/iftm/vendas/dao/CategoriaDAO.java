package br.edu.iftm.vendas.dao;

import br.edu.iftm.vendas.entidade.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria, Integer>{

    public CategoriaDAO() {
        super(Categoria.class);
    }
    
}
