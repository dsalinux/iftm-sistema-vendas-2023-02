package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.logica.CrudLogic;
import br.edu.iftm.vendas.logica.UsuarioLogic;
import br.edu.iftm.vendas.util.excption.ErroNegocioException;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import lombok.Getter;

public abstract class CrudBean<E, L extends CrudLogic<E>> extends JSFUtil {

    @Getter
    private E entidade;
    @Getter
    private List<E> entidades;
    private Class<E> classeEntidade;
    private L logic;

    public CrudBean(Class<E> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }

    // Enum para controlar o estado da tela
    public enum EstadoTela {
        CRIAR,
        EDITAR,
        PESQUISAR
    }
    @Getter
    private EstadoTela estadoTela = EstadoTela.PESQUISAR;

    public void novo() {
        try {
            entidade = (E) classeEntidade.getConstructors()[0].newInstance();
            estadoTela = EstadoTela.CRIAR;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() {
        try {
            //Codigo para salvar
            getLogic().salvar(entidade);
            addInfo("Salvo com sucesso.");
            estadoTela = EstadoTela.PESQUISAR;
        } catch (ErroSistemaException ex) {
            addErro(ex);
            ex.printStackTrace();
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (ErroNegocioException ex) {
            addAviso(ex.getMessage());
        }
    }

    public void deletar(E entidade) {
        try {
            getLogic().remover(entidade);
            addInfo("Removido com sucesso.");
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (ErroNegocioException ex) {
            addAviso(ex.getMessage());
        }
    }

    public void editar(E entidade) {
        try {
            this.entidade = getLogic().buscarPorID(entidade);
            estadoTela = EstadoTela.EDITAR;
        }  catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (ErroNegocioException ex) {
            addAviso(ex.getMessage());
        }
    }

    public void pesquisar() {
        if (!estadoTela.equals(EstadoTela.PESQUISAR)) {
            estadoTela = EstadoTela.PESQUISAR;
            return;
        }
        try {
            entidades = getLogic().buscar(entidade);
            if(entidades == null || entidades.isEmpty()) {
                addAviso("A pesquisa não encontrou registros.");
            }
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex.getMessage());
        }
    }

    public abstract L getLogic();
}
