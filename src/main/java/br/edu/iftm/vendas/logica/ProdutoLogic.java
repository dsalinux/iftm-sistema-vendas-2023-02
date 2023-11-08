/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.vendas.logica;

import br.edu.iftm.vendas.dao.ProdutoDAO;
import br.edu.iftm.vendas.entidade.Produto;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class ProdutoLogic implements CrudLogic<Produto> {

    @Inject
    private ProdutoDAO dao;

    @Override
    public Produto salvar(Produto entidade) throws ErroSistemaException, ErroNegocioException {
        dao.salvar(entidade);
        return entidade;
    }

    @Override
    public void remover(Produto entidade) throws ErroSistemaException, ErroNegocioException {
        dao.remover(entidade);
    }

    @Override
    public Produto buscarPorID(Produto entidade) throws ErroSistemaException, ErroNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Produto> buscar(Produto entidade) throws ErroSistemaException, ErroNegocioException {
        return dao.listar();
    }

}
