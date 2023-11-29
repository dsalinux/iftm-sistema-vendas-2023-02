package br.edu.iftm.vendas.dao;

import br.edu.iftm.vendas.entidade.Usuario;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class GenericDAO<E, ID> implements Serializable{
    @Inject
    private EntityManager manager;

    private Class<E> classEntity;
    
    public GenericDAO(Class<E> classEntity) {
        this.classEntity = classEntity;
    }
    
    public void salvar(E entity) throws ErroSistemaException {
        try {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
        } catch (Exception ex) {
            manager.getTransaction().rollback();
            throw new ErroSistemaException("Erro ao salvar.", ex);
        }
    }

    public void remover(ID id) throws ErroSistemaException {
        manager.getTransaction().begin();
        E entity = manager.find(classEntity, id);
        manager.remove(entity);
        manager.getTransaction().commit();
    }

    public E buscarPorID(ID id) {
        E entity = manager.find(classEntity, id);
        return entity;
    }
    
    public List<E> listar() throws ErroSistemaException {
        List<E> entitys = manager.createQuery("from "+classEntity.getCanonicalName()).getResultList();
        return entitys;
    }
    
}
