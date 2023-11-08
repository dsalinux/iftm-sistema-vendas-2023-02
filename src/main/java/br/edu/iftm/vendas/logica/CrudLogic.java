package br.edu.iftm.vendas.logica;

import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.io.Serializable;
import java.util.List;

public interface CrudLogic<E> extends Serializable {
    
    public E salvar(E entidade) throws ErroSistemaException, ErroNegocioException;
    public void remover(E entidade) throws ErroSistemaException, ErroNegocioException;
    public E buscarPorID(E entidade) throws ErroSistemaException, ErroNegocioException;
    public List<E> buscar(E entidade) throws ErroSistemaException, ErroNegocioException;
    
}
