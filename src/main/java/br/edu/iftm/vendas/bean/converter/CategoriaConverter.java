/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.vendas.bean.converter;

import br.edu.iftm.vendas.entidade.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(forClass = Categoria.class, value = "categoriaConverter")
public class CategoriaConverter implements Converter<Categoria>{

    @Override
    public Categoria getAsObject(FacesContext context, UIComponent component, String id) {
        Categoria categoria = (Categoria) component.getAttributes().get("categoria_"+id);
        return categoria;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Categoria categoria) {
        if(categoria != null) {
            component.getAttributes().put("categoria_"+categoria.getId(), categoria);
            return categoria.getId()+"";
        }
        return null;
    }
    
}
