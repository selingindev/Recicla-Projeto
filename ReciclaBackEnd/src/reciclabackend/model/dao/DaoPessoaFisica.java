/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.model.dao;

/**
 *
 * @author Cateli
 */



import java.sql.*;
import java.util.*;
import reciclabackend.model.bean.PessoaFisica;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoPessoaFisica implements DaoBasico {

    @Override
    public Object inserir(Object obj) throws SQLException {
        PessoaFisica pf = (PessoaFisica) obj;
        String sql = "INSERT INTO pef_pessoafisica (idpes, cpf, rg) VALUES (?, ?, ?)";

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, pf.getIdPes());
        ps.setString(2, pf.getCpf());
        ps.setString(3, pf.getRg());
        ps.executeUpdate();

        return pf;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        PessoaFisica pf = (PessoaFisica) obj;
        String sql = "UPDATE pef_pessoafisica SET cpf = ?, rg = ? WHERE idpes = ?";

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, pf.getCpf());
        ps.setString(2, pf.getRg());
        ps.setInt(3, pf.getIdPes());
        ps.executeUpdate();

        return pf;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        
        String sql = "DELETE FROM pef_pessoafisica WHERE id = ?";

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id());
        ps.executeUpdate();

        return pf;
    }

    @Override
    public Object buscar(int id) throws SQLException {
        
        String sql = "SELECT * FROM pef_pessoafisica WHERE id = ?";

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            pf.setCpf(rs.getString("cpf"));
            pf.setRg(rs.getString("rg"));
        }

        return pf;
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        String sql = "SELECT * FROM pef_pessoafisica";
        List<Object> lista = new ArrayList<>();

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PessoaFisica pf = new PessoaFisica();
            pf.setIdPes(rs.getInt("idpes"));
            pf.setCpf(rs.getString("cpf"));
            pf.setRg(rs.getString("rg"));
            lista.add(pf);
        }

        return lista;
    }
}
