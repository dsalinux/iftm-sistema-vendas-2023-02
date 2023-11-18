/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.vendas.dao;

import br.edu.iftm.vendas.entidade.Usuario;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danilo
 */
public abstract class GenericDAO<E, ID> implements Serializable{
    @Inject
    private EntityManager manager;

    private Class<E> classEntity;
    
    public GenericDAO(Class<E> classEntity) {
        this.classEntity = classEntity;
    }
    
    public void salvar(E entity) throws ErroSistemaException {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    public void remover(ID id) throws ErroSistemaException {
        manager.getTransaction().begin();
        E entity = manager.find(classEntity, id);
        manager.remove(entity);
        manager.getTransaction().commit();
    }

    public List<E> listar() throws ErroSistemaException {
        List<E> entitys = manager.createQuery("from "+classEntity.getCanonicalName()).getResultList();
        return entitys;
    }
    
}
