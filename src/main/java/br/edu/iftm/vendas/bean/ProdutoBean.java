package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.entidade.Categoria;
import br.edu.iftm.vendas.entidade.Produto;
import br.edu.iftm.vendas.logica.CategoriaLogic;
import br.edu.iftm.vendas.logica.ProdutoLogic;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProdutoBean extends CrudBean<Produto, ProdutoLogic>{

    @Inject
    private CategoriaLogic categoriaLogic;
    
    private List<Categoria> categorias;
    
    private Long ultimaAtualizacao = 0L;
    
    @Inject
    private ProdutoLogic logic;
    
    public ProdutoBean() {
        super(Produto.class);
    }

    @Override
    public ProdutoLogic getLogic() {
        return logic;
    }
    
    
    public List<Categoria> getCategorias() {
        try {
            Long agora = new Date().getTime();
            if(categorias == null || agora > ultimaAtualizacao + 10000) {
                categorias = categoriaLogic.buscar(null);
                ultimaAtualizacao = agora;
            } 
            return categorias;
        } catch (ErroSistemaException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
            addErro(ex);
        } catch (ErroNegocioException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
            addAviso(ex.getMessage());
        }
        return new ArrayList<>();
    }
}
