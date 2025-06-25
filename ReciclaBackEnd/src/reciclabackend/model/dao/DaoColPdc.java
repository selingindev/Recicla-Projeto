package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reciclabackend.model.bean.ColPdc;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

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
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM COL_PDC WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return true;
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM COL_PDC WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        ColPdc resultado = null;

        if (rs.next()) {
            resultado = new ColPdc(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
        }

        rs.close();
        stmt.close();
        return resultado;
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT * FROM COL_PDC";

        boolean temFiltro = pfiltro != null && !pfiltro.isEmpty();
        if (temFiltro) {
            sql += " WHERE CAST(id_col AS CHAR) LIKE ?";
        }

        PreparedStatement stmt = this.c.prepareStatement(sql);

        if (temFiltro) {
            stmt.setString(1, "%" + pfiltro + "%");
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ColPdc col = new ColPdc(
                    rs.getInt("id"), // ou rs.getInt(1) se preferir
                    rs.getInt("id_col"),
                    rs.getInt("id_pdc"),
                    rs.getString("descricao"));
            lista.add(col);
        }

        rs.close();
        stmt.close();
        return lista;
    }

}
