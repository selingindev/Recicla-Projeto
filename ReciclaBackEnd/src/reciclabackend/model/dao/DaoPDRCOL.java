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
import reciclabackend.model.bean.PdrCol;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

/**
 *
 * @author LAB 211
 */
public class DaoPDRCOL implements DaoBasico {
    
    private final Connection c;
    
    public DaoPDRCOL() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PdrCol validar(PdrCol entidade) throws SQLException {
        String sql = "SELECT * FROM PDR_COL WHERE id_pdr = ? AND id_col = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, entidade.getIdPRD());
        stmt.setInt(2, entidade.getIdCOL());
        ResultSet rs = stmt.executeQuery();
        PdrCol resultado = null;
        if (rs.next()) {      
            resultado = new PdrCol(
                rs.getInt("id"),
                rs.getInt("id_pdr"),
                rs.getInt("id_col")
            );
        }
        stmt.close();
        return resultado;
    }
    
    @Override
    public Object inserir(Object obj) throws SQLException {
        PdrCol entidade = (PdrCol) obj;
        String sql = "INSERT INTO PDR_COL (id_pdr, id_col) VALUES (?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, entidade.getIdPRD());
        stmt.setInt(2, entidade.getIdCOL());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            entidade.setId(rs.getInt(1));
        }
        stmt.close();
        return entidade;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        PdrCol entidade = (PdrCol) obj;
        String sql = "UPDATE PDR_COL SET id_pdr = ?, id_col = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, entidade.getIdPRD());
        stmt.setInt(2, entidade.getIdCOL());
        stmt.setInt(3, entidade.getId());
        stmt.execute();
        stmt.close();
        return entidade;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        PdrCol entidade = (PdrCol) obj;
        String sql = "DELETE FROM PDR_COL WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, entidade.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return entidade;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        PdrCol entidade = (PdrCol) obj;
        String sql = "SELECT * FROM PDR_COL WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, entidade.getId());
        ResultSet rs = stmt.executeQuery();
        PdrCol resultado = null;
        if (rs.next()) {      
            resultado = new PdrCol(
                rs.getInt("id"),
                rs.getInt("id_pdr"),
                rs.getInt("id_col")
            );
        }
        stmt.close();
        return resultado;
    }
    
    @Override
    public List<Object> listar(Object obj) throws SQLException {
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT * FROM PDR_COL";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {      
            PdrCol entidade = new PdrCol(
                rs.getInt("id"),
                rs.getInt("id_pdr"),
                rs.getInt("id_col")
            );
            lista.add(entidade);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}