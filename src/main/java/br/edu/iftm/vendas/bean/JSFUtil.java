package br.edu.iftm.vendas.bean;

import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil implements Serializable{
    
    public void addMensagem(FacesMessage.Severity severity, String resumo, String detalhe) {
        FacesMessage message = new FacesMessage(severity, resumo, detalhe);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addInfo(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_INFO, resumo, detalhe);
    }
    public void addInfo(String detalhe){
        addInfo("Info",detalhe);
    }
    
    public void addAviso(String resumo, String detalhe) {
        addMensagem(FacesMessage.SEVERITY_WARN, resumo, detalhe);
    }
    public void addAviso(String detalhe) {
        addAviso("Aviso", detalhe);
    }
    
    public void addErro(String resumo, String detalhe) {
        addMensagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }
    public void addErro(String detalhe) {
        addErro("Erro", detalhe);
    }
    public void addErro(ErroSistemaException ex) {
        addErro("Erro", ex.getMessage());
    }
}
