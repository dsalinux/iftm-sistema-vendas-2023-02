package br.edu.iftm.vendas.dao;

import br.edu.iftm.vendas.entidade.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Integer>{

    public ProdutoDAO() {
        super(Produto.class);
    }
  
}
