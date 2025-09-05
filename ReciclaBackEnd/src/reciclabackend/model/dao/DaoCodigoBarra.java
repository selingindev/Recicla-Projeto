package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reciclabackend.model.bean.CodigoBarras;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoCodigoBarra implements DaoBasico {
    private final Connection c;

    public DaoCodigoBarra() {
             this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        CodigoBarras cbEnt = (CodigoBarras) obj;

        String sql = "INSERT INTO CODIGOBARRAS (description, gtdin, brandName) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cbEnt.getDescription());
            stmt.setString(2, cbEnt.getGtdin());
            stmt.setString(3, cbEnt.getBrandName());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                cbEnt.setId(rs.getInt(1));
            }

            return cbEnt;
        }
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        CodigoBarras cbEnt = (CodigoBarras) obj;

        String sql = "UPDATE CODIGOBARRAS SET description = ?, gtdin = ?, brandName = ? WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, cbEnt.getDescription());
            stmt.setString(2, cbEnt.getGtdin());
            stmt.setString(3, cbEnt.getBrandName());
            stmt.setInt(4, cbEnt.getId());

            stmt.executeUpdate();
            return cbEnt;
        }
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM CODIGOBARRAS WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM CODIGOBARRAS WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                CodigoBarras cb = new CodigoBarras(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getString("gtdin"),
                        rs.getString("brandName"));
                return cb;
            }

            return null; // Retorna null se não encontrar
        }
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        String sql = "SELECT * FROM CODIGOBARRAS WHERE gtdin LIKE ?";
        List<Object> lista = new ArrayList<>();

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, "%" + pfiltro + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CodigoBarras cb = new CodigoBarras(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getString("gtdin"),
                        rs.getString("brandName"));
                lista.add(cb);
            }

            return lista;
        }
    }

}
