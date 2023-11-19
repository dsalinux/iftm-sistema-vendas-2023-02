package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.entidade.Permissao;
import br.edu.iftm.vendas.entidade.Usuario;
import br.edu.iftm.vendas.logica.PermissaoLogic;
import br.edu.iftm.vendas.logica.UsuarioLogic;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic>{
    
    @Inject
    private UsuarioLogic logic;
    
    @Inject
    private PermissaoLogic permissaoLogic;
    
    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public UsuarioLogic getLogic() {
        return logic;
    }
    
    public List<Permissao> getPermissoes(){
        try {
            return permissaoLogic.buscar(null);
        } catch (ErroSistemaException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex.getMessage());
        }
        return new ArrayList<>();
    }
    
}
