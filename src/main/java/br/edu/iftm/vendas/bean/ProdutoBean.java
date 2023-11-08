package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.entidade.Produto;
import br.edu.iftm.vendas.logica.ProdutoLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProdutoBean extends CrudBean<Produto, ProdutoLogic>{

    @Inject
    private ProdutoLogic logic;
    
    public ProdutoBean() {
        super(Produto.class);
    }

    @Override
    public ProdutoLogic getLogic() {
        return logic;
    }
    
}
