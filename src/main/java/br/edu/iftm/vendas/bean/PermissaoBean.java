package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.entidade.Permissao;
import br.edu.iftm.vendas.logica.PermissaoLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PermissaoBean extends CrudBean<Permissao, PermissaoLogic>{
    
    @Inject
    private PermissaoLogic logic;
    
    public PermissaoBean() {
        super(Permissao.class);
    }

    @Override
    public PermissaoLogic getLogic() {
        return logic;
    }
    
}
