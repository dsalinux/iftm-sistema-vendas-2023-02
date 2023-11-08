package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.entidade.Usuario;
import br.edu.iftm.vendas.logica.UsuarioLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic>{
    
    @Inject
    private UsuarioLogic logic;
    
    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public UsuarioLogic getLogic() {
        return logic;
    }
    
}
