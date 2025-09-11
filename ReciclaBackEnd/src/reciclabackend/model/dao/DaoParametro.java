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
 
import reciclabackend.model.bean.Parametro;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoParametro implements DaoBasico{
    private final Connection c;
 
    public DaoParametro() throws SQLException, ClassNotFoundException{
          this.c = ConexaoDb.getConexaoMySQL();
    }
 
    @Override
    public Object inserir(Object obj) throws SQLException {
        Parametro parametro = (Parametro) obj;
 
        String sql = "insert into PAR_PARAMETROS" + " (ID, COD, DESCRICAO)" + " values (?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, parametro.getId());
        stmt.setInt(2, parametro.getCod());
        stmt.setString(3, parametro.getDescricao());
 
          // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            parametro.setId(id);
        }
        stmt.close();
        return parametro;
    }
 
    @Override
    public Object alterar(Object obj) throws SQLException {
        Parametro parametro = (Parametro) obj; 
        String sql = "UPDATE PAR_PARAMETROS SET COD = ?, DESCRICAO = ? WHERE ID = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, parametro.getCod());
        stmt.setString(2, parametro.getDescricao());
        stmt.setInt(3, parametro.getId());
        stmt.execute();
        stmt.close();
 
        return parametro;
        }   
 
    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "delete from PAR_PARAMETRO WHERE ID = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return true;
       }
 
    @Override
    public Object buscar(int cod) throws SQLException {
        String sql = "select * from PAR_PARAMETRO WHERE COD = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
 
        stmt.setInt(1, cod);
        ResultSet rs = stmt.executeQuery();
        Parametro logSaida = null;
        while (rs.next()) {      
            logSaida = new Parametro(
                rs.getInt(1),
                rs.getString(3)
            );
        }
        stmt.close();
        return logSaida;
    }
 
     @Override
    public List<Object> listar(String filtro) throws SQLException  {
        List<Object> param = new ArrayList<>();
        String sql = "select * from PAR_PARAMETROS";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,0);
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {      
            Parametro parametro = new Parametro(
                rs.getInt(1),
                rs.getString(3)
            );
            param.add(parametro);
        }
        rs.close();
        stmt.close();
        return param;
    }
}
