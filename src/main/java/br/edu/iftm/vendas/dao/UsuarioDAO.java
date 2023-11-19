package br.edu.iftm.vendas.dao;

import br.edu.iftm.vendas.entidade.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Integer>{

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public Usuario buscarPorID(Integer id) {
        Usuario usuario = super.buscarPorID(id);
        usuario.getPermissoes().size();
        return usuario;
    }
    
    
}
