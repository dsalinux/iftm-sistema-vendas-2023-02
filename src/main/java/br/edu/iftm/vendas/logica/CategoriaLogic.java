package br.edu.iftm.vendas.logica;

import br.edu.iftm.vendas.dao.CategoriaDAO;
import br.edu.iftm.vendas.entidade.Categoria;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class CategoriaLogic implements CrudLogic<Categoria>{

    
    @Inject
    private CategoriaDAO dao;
    
    @Override
    public Categoria salvar(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        dao.salvar(entidade);
        return entidade;
    }

    @Override
    public void remover(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        dao.remover(entidade.getId());
    }

    @Override
    public Categoria buscarPorID(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        return dao.buscarPorID(entidade.getId());
    }

    @Override
    public List<Categoria> buscar(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        return dao.listar();
    }
    
}
