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
        stmt.setString(5, pef.getCod());
        stmt.setDouble(6, pef.getQuant());
        stmt.setDate(7, pef.getData());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            pef.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
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
        stmt.setString(5, pef.getCod());
        stmt.setDouble(6, pef.getQuant());
        stmt.setDate(7, pef.getData());
        stmt.setInt(8, pef.getId());
        stmt.executeUpdate();
        stmt.close();
        return pef;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM pef_pdc WHERE id=?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        stmt.close();
        return rows > 0;
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM pef_pdc WHERE id=?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        PefPdc pef = null;
        if (rs.next()) {
            pef = new PefPdc(
                rs.getInt("id"),
                rs.getInt("id_pef"),
                rs.getInt("id_col"),
                rs.getInt("id_mat"),
                rs.getInt("id_pdc"),
                rs.getString("cod"),
                rs.getDouble("quant"),
                rs.getDate("data")
            );
        }
        rs.close();
        stmt.close();
        return pef;
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException {
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT * FROM pef_pdc WHERE cod LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, "%" + filtro + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(new PefPdc(
                rs.getInt("id"),
                rs.getInt("id_pef"),
                rs.getInt("id_col"),
                rs.getInt("id_mat"),
                rs.getInt("id_pdc"),
                rs.getString("cod"),
                rs.getDouble("quant"),
                rs.getDate("data")
            ));
        }
        rs.close();
        stmt.close();
        return lista;
    }
}