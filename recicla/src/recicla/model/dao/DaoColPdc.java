package recicla.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import recicla.model.bean.ColPdc;
import recicla.util.ConexaoDb;
import recicla.util.DaoBasico;

public class DaoColPdc implements DaoBasico {

    private final Connection c;

    public DaoColPdc() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        ColPdc col = (ColPdc) obj;
        String sql = "INSERT INTO COL_PDC (id_col, id_pdc, data) VALUES (?, ?, ?)";

        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, col.getIdCol());
        stmt.setInt(2, col.getIdPdc());
        stmt.setDate(3, Date.valueOf(col.getData()));

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            col.setId(rs.getInt(1));
        }

        stmt.close();
        return col;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        ColPdc col = (ColPdc) obj;
        String sql = "UPDATE COL_PDC SET id_col = ?, id_pdc = ?, data = ? WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, col.getIdCol());
        stmt.setInt(2, col.getIdPdc());
        stmt.setDate(3, Date.valueOf(col.getData()));
        stmt.setInt(4, col.getId());

        stmt.executeUpdate();
        stmt.close();
        return col;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        ColPdc col = (ColPdc) obj;
        String sql = "DELETE FROM COL_PDC WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, col.getId());

        stmt.executeUpdate();
        stmt.close();
        return col;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        ColPdc col = (ColPdc) obj;
        String sql = "SELECT * FROM COL_PDC WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, col.getId());

        ResultSet rs = stmt.executeQuery();
        ColPdc resultado = null;

        if (rs.next()) {
            resultado = new ColPdc(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getTimestamp(4).toLocalDateTime().toLocalDate()
                
            );
        }

        rs.close();
        stmt.close();
        return resultado;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException {
        ColPdc filtro = (ColPdc) obj;
        List<Object> lista = new ArrayList<>();

        String sql = "SELECT * FROM COL_PDC WHERE id_col = ? OR ? IS NULL";
        PreparedStatement stmt = c.prepareStatement(sql);
        if (filtro.getIdCol() != 0) {
            stmt.setInt(1, filtro.getIdCol());
            stmt.setNull(2, java.sql.Types.INTEGER);
        } else {
            stmt.setNull(1, java.sql.Types.INTEGER);
            stmt.setInt(2, 1);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ColPdc col = new ColPdc(
                rs.getInt("id"),
                rs.getInt("id_col"),
                rs.getInt("id_pdc"),
                rs.getTimestamp("data").toLocalDateTime().toLocalDate()
            );
            lista.add(col);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}
