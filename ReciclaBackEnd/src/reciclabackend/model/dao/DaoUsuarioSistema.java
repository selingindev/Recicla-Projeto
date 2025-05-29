/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.model.dao;

import reciclabackend.model.bean.UsuarioSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

/**
 *
 * @author User
 */
public class DaoUsuarioSistema implements DaoBasico {

    private final Connection c;
    
    public DaoUsuarioSistema() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object excluir(Object obj) throws SQLException{
        UsuarioSistema usuEnt = (UsuarioSistema) obj;
        String sql = "delete from usuarios_sistemas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usuEnt;
    }
    
    @Override
    public Object buscar(Object obj) throws SQLException{
        UsuarioSistema usuEnt = (UsuarioSistema) obj;
        String sql = "select * from usuarios_sistemas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usuEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuarioSistema usuSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new UsuarioSistema(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usuSaida;
   }

    @Override
    public Object inserir(Object obj) throws SQLException{
        UsuarioSistema usuEnt = (UsuarioSistema) obj;
        String sql = "insert into usuarios_sistemas" + " (idU, idS, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,usuEnt.getIdU());
        stmt.setInt(2,usuEnt.getIdS());
        stmt.setString(3,usuEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usuEnt.setId(id);
        }
        stmt.close();
        return usuEnt;
    }

    @Override
    public Object alterar(Object obj) throws SQLException{
        UsuarioSistema usuEnt = (UsuarioSistema) obj;
        String sql = "UPDATE usuarios_sistemas SET idU = ?, idS = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuEnt.getIdU());
        stmt.setInt(2,usuEnt.getIdS());
        stmt.setString(3,usuEnt.getObs());
        stmt.setInt(4,usuEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return usuEnt;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException{
         UsuarioSistema usuEnt = (UsuarioSistema) obj;
        // usus: array armazena a lista de registros
        List<Object> usus = new ArrayList<>();
        
        String sql = "select * from usuarios_sistemas where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            UsuarioSistema usu = new UsuarioSistema(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
   }

    
}
