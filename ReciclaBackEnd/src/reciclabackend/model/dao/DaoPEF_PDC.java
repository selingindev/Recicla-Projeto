package reciclabackend.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import reciclabackend.model.bean.PefPdc;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoPEF_PDC implements DaoBasico {

    private final Connection c;

    public DaoPEF_PDC() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        PefPdc pef = (PefPdc) obj;
        String sql = "INSERT INTO pef_pdc (id_pef, id_col, id_mat, id_pdc, cod, quant, data) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, pef.getIdPef());
        stmt.setInt(2, pef.getIdCol());
        stmt.setInt(3, pef.getIdMat());
        stmt.setInt(4, pef.getIdPdc());
        stmt.setInt(5, pef.getCod());
        stmt.setInt(6, pef.getQuant());
        stmt.setString(7, pef.getData());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) pef.setId(rs.getInt(1));
        rs.close(); stmt.close();
        return pef;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        PefPdc pef = (PefPdc) obj;
        String sql = "UPDATE pef_pdc SET id_pef=?, id_col=?, id_mat=?, id_pdc=?, cod=?, quant=?, data=? WHERE id=?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, pef.getIdPef());
        stmt.setInt(2, pef.getIdCol());
        stmt.setInt(3, pef.getIdMat());
        stmt.setInt(4, pef.getIdPdc());
        stmt.setInt(5, pef.getCod());
        stmt.setInt(6, pef.getQuant());
        stmt.setString(7, pef.getData());
        stmt.setInt(8, pef.getId());
        stmt.executeUpdate();
        stmt.close();
        return pef;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        PefPdc pef = (PefPdc) obj;
        String sql = "DELETE FROM pef_pdc WHERE id=?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, pef.getId());
        stmt.executeUpdate();
        stmt.close();
        return pef;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        PefPdc pefEnt = (PefPdc) obj;
        String sql = "SELECT * FROM pef_pdc WHERE id=?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, pefEnt.getId());
        ResultSet rs = stmt.executeQuery();
        PefPdc pef = null;
        if (rs.next()) {
            pef = new PefPdc(
                rs.getInt("id"),
                rs.getInt("id_pef"),
                rs.getInt("id_col"),
                rs.getInt("id_mat"),
                rs.getInt("id_pdc"),
                rs.getInt("cod"),
                rs.getInt("quant"),
                rs.getString("data")
            );
        }
        rs.close(); stmt.close();
        return pef;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException {
        PefPdc filtro = (PefPdc) obj;
        String sql = "SELECT * FROM pef_pdc WHERE id_pef=?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, filtro.getIdPef());
        ResultSet rs = stmt.executeQuery();
        List<Object> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new PefPdc(
                rs.getInt("id"),
                rs.getInt("id_pef"),
                rs.getInt("id_col"),
                rs.getInt("id_mat"),
                rs.getInt("id_pdc"),
                rs.getInt("cod"),
                rs.getInt("quant"),
                rs.getString("data")
            ));
        }
        rs.close(); stmt.close();
        return lista;
    }
}
