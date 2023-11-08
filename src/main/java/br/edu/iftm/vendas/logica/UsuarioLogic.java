package br.edu.iftm.vendas.logica;

import br.edu.iftm.vendas.dao.UsuarioDAO;
import br.edu.iftm.vendas.entidade.Usuario;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class UsuarioLogic implements CrudLogic<Usuario>{

    
    @Inject
    private UsuarioDAO dao;
    
    @Override
    public Usuario salvar(Usuario entidade) throws ErroSistemaException, ErroNegocioException {
        if(entidade.getDataCadastro() == null) {
            entidade.setDataCadastro(new Date());
        }
        dao.salvar(entidade);
        return entidade;
    }

    @Override
    public void remover(Usuario entidade) throws ErroSistemaException, ErroNegocioException {
        dao.remover(entidade);
    }

    @Override
    public Usuario buscarPorID(Usuario entidade) throws ErroSistemaException, ErroNegocioException {
        return null;
    }

    @Override
    public List<Usuario> buscar(Usuario entidade) throws ErroSistemaException, ErroNegocioException {
        return dao.listar();
    }
    
}
