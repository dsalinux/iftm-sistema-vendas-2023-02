/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.vendas.dao;

import br.edu.iftm.vendas.entidade.Usuario;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements Serializable {

    private Connection getConexao() throws ErroSistemaException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/iftm-vendas-teste";
            String usuario = "root";
            String senha = "Daniloif123@";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ErroSistemaException("Erro ao conectar no banco de dados", ex);
        }
    }

    public void salvar(Usuario usuario) throws ErroSistemaException {
        try {
            Connection conexao = getConexao();
            PreparedStatement ps;
            if (usuario.getCodigo() == null) {
                ps = conexao.prepareStatement("insert into usuario (`nome`, `email`, `senha`, `data_cadastro`) values (?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update usuario set `nome` = ?, `email` = ?, `senha` = ?, `data_cadastro` = ? where codigo = ?");
                ps.setInt(5, usuario.getCodigo());
            }
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setDate(4, new java.sql.Date(usuario.getDataCadastro().getTime()));
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistemaException("Erro ao tentar salvar usuário.", ex);
        }
    }

    public void remover(Usuario usuario) throws ErroSistemaException {
        try {
            Connection conexao = getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("delete from usuario  where codigo = ?");
            ps.setInt(1, usuario.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistemaException("Erro ao tentar remover usuário.", ex);
        }
    }

    public List<Usuario> listar() throws ErroSistemaException {
        try {
            Connection conexao = getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("select * from usuario");
            ResultSet rs = ps.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList<>();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setDataCadastro(rs.getDate("data_cadastro"));
                listaUsuarios.add(usuario);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            throw new ErroSistemaException("Erro ao tentar listar os usuários.", ex);
        }
    }
}
