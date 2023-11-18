package br.edu.iftm.vendas.dao;

import br.edu.iftm.vendas.entidade.Produto;
import br.edu.iftm.vendas.util.excption.ErroSistemaException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements Serializable {

    private Connection getConexao() throws ErroSistemaException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/iftm-vendas-teste";
            String produto = "root";
            String senha = "Daniloif123@";
            Connection conexao = DriverManager.getConnection(url, produto, senha);
            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ErroSistemaException("Erro ao conectar no banco de dados", ex);
        }
    }

    public void salvar(Produto produto) throws ErroSistemaException {
        try {
            Connection conexao = getConexao();
            PreparedStatement ps;
            if (produto.getId()== null) {
                ps = conexao.prepareStatement("insert into produto (`nome`, `descricao`, `preco`, `marca`, `cor`) values (?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update produto set `nome` = ?, `descricao` = ?, `preco` = ?, `marca` = ?, `cor` = ? where id = ?");
                ps.setInt(6, produto.getId());
            }
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setBigDecimal(3, produto.getPreco());
            ps.setString(4, produto.getMarca());
            ps.setString(5, produto.getCor());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistemaException("Erro ao tentar salvar usuário.", ex);
        }
    }

    public void remover(Produto produto) throws ErroSistemaException {
        try {
            Connection conexao = getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("delete from produto  where codigo = ?");
            ps.setInt(1, produto.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistemaException("Erro ao tentar remover usuário.", ex);
        }
    }

    public List<Produto> listar() throws ErroSistemaException {
        try {
            Connection conexao = getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("select * from produto");
            ResultSet rs = ps.executeQuery();
            List<Produto> listaProdutos = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setMarca(rs.getString("marca"));
                produto.setCor(rs.getString("cor"));
                listaProdutos.add(produto);
            }
            return listaProdutos;
        } catch (SQLException ex) {
            throw new ErroSistemaException("Erro ao tentar listar os usuários.", ex);
        }
    }
}
