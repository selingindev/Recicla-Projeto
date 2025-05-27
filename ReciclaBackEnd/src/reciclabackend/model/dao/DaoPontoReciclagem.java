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
import reciclabackend.model.bean.PontoReciclagem;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

/**
 *
 * @author LAB 211
 */
public class DaoPontoReciclagem implements DaoBasico {
    
    private final Connection c;
    
    public DaoPontoReciclagem() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PontoReciclagem validar(PontoReciclagem idEnt) throws SQLException {
        // cria o select para ser executado no banco de dados 
        String sql = "select * from pdr_ponto_reciclagem WHERE ID = ? AND nome = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,idEnt.getIdPEJ());
        stmt.setString(2,idEnt.getNome());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        PontoReciclagem idSaida = null;
        while (rs.next()) {      
            // criando o objeto Usuario
            idSaida = new PontoReciclagem(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        System.out.println(idSaida);
        return idSaida; 
    }

    
    @Override
    public Object inserir(Object obj) throws SQLException {
        PontoReciclagem idEnt = (PontoReciclagem) obj;
        String sql = "INSERT INTO pdr_ponto_reciclagem (idpej, nome) VALUES (?, ?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,idEnt.getIdPEJ());
        stmt.setString(2,idEnt.getNome());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            idEnt.setId(id);
        }
        stmt.close();
        return idEnt;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        PontoReciclagem idEnt = (PontoReciclagem) obj;
        String sql = "UPDATE pdr_ponto_reciclagem SET IDPEJ = ?, NOME = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,idEnt.getIdPEJ());
        stmt.setString(2,idEnt.getNome());
        stmt.setInt(3,idEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        return idEnt;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        PontoReciclagem idEnt = (PontoReciclagem) obj;
        String sql = "delete from pdr_ponto_reciclagem WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,idEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return idEnt;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        PontoReciclagem idEnt = (PontoReciclagem) obj;
        String sql = "select * from pdr_ponto_reciclagem WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,idEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PontoReciclagem idSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                idSaida = new PontoReciclagem(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return idSaida;
    }
    
    
    @Override
    public List<Object> listar(Object obj) throws SQLException  {
        PontoReciclagem idEnt = (PontoReciclagem) obj;
        // usus: array armazena a lista de registros
        List<Object> ids = new ArrayList<>();
        
        String sql = "select * from pdr_ponto_reciclagem WHERE IDPEJ like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + idEnt.getIdPEJ() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PontoReciclagem id = new PontoReciclagem(
                rs.getInt("ID"),
                rs.getInt("IDPEJ"),
                rs.getString("NOME")
            );
            // adiciona o usu à lista de usus
            ids.add(id);
        }
        
        rs.close();
        stmt.close();
        return ids;
    }
    
}
