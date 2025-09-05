/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reciclabackend.model.bean.Pessoa;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

/**
 *
 * @author olgac
 */
public class DaoPessoa implements DaoBasico {

    private final Connection c;

    public DaoPessoa() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        Pessoa pessoaEnt = (Pessoa) obj;
        String sql = "insert into PES_PESSOA" + " (NOME, id_log, EMAIL, TELEFONE)" + " values (?, ?, ?, ?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,pessoaEnt.getNome());
        stmt.setInt(2, pessoaEnt.getIdLog());
        stmt.setString(3, pessoaEnt.getEmail());
        stmt.setString(4, pessoaEnt.getTelefone());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pessoaEnt.setId(id);
        }
        stmt.close();
        return pessoaEnt;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        Pessoa pessoaEnt = (Pessoa) obj;
        String sql = "UPDATE PES_PESSOA SET nome = ?, id_log = ? email = ?, telefone = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,pessoaEnt.getNome());
        stmt.setInt(2, pessoaEnt.getIdLog());
        stmt.setInt(3,pessoaEnt.getId());
        stmt.setString(4, pessoaEnt.getEmail());
        stmt.setString(5, pessoaEnt.getTelefone());
        // executa
        stmt.execute();
        stmt.close();
        return pessoaEnt;
    }

    
    public List<Object> listarTodos() throws SQLException  {
        
        // usus: array armazena a lista de registros
        List<Object> pessoas = new ArrayList<>();
        
        String sql = "select * from PES_PESSOA";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Pessoa pessoa = new Pessoa(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5) 
            );
            // adiciona o usu à lista de usus
            pessoas.add(pessoa);
        }
        
        rs.close();
        stmt.close();
        return pessoas;
    }

    @Override
    public boolean excluir(int id) throws SQLException {

        String sql = "delete from PES_PESSOA WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,id);
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return true;    
    }

    @Override
    public Object buscar(int id) throws SQLException {
        
        String sql = "select * from PES_PESSOA WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,id);
            // executa
            ResultSet rs = stmt.executeQuery();
            Pessoa pesSaida = null;
            while (rs.next()) {      
            // criando o objeto Pessoa
            pesSaida = new Pessoa(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5)
                    );
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pesSaida;    
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        List<Object> pessoas = new ArrayList<>();
        
        String sql = "select * from PES_PESSOA where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pfiltro + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Pessoa pessoa = new Pessoa(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            pessoas.add(pessoa);
        }
        
        rs.close();
        stmt.close();
        return pessoas;    }
}