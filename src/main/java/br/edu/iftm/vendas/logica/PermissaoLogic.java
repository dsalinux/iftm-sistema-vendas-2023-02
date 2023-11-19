package br.edu.iftm.vendas.logica;

import br.edu.iftm.vendas.dao.PermissaoDAO;
import br.edu.iftm.vendas.entidade.Permissao;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class PermissaoLogic implements CrudLogic<Permissao>{

    
    @Inject
    private PermissaoDAO dao;
    
    @Override
    public Permissao salvar(Permissao entidade) throws ErroSistemaException, ErroNegocioException {
        dao.salvar(entidade);
        return entidade;
    }

    @Override
    public void remover(Permissao entidade) throws ErroSistemaException, ErroNegocioException {
        dao.remover(entidade.getId());
    }

    @Override
    public Permissao buscarPorID(Permissao entidade) throws ErroSistemaException, ErroNegocioException {
        return null;
    }

    @Override
    public List<Permissao> buscar(Permissao entidade) throws ErroSistemaException, ErroNegocioException {
        return dao.listar();
    }
    
}
