package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.entidade.Categoria;
import br.edu.iftm.vendas.logica.CategoriaLogic;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CategoriaBean extends CrudBean<Categoria, CategoriaLogic>{
    
    @Inject
    private CategoriaLogic logic;
    
    public CategoriaBean() {
        super(Categoria.class);
    }

    @Override
    public CategoriaLogic getLogic() {
        return logic;
    }
    
    public List<Categoria> getCategorias() {
        try {
            return this.logic.buscar(null);
        } catch (ErroSistemaException ex) {
            Logger.getLogger(CategoriaBean.class.getName()).log(Level.SEVERE, null, ex);
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex.getMessage());
        }
        return new ArrayList<>();
    }
    
}
