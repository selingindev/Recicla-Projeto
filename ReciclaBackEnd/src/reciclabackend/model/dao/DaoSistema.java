package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reciclabackend.model.bean.Sistema;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoSistema implements DaoBasico {

    private final Connection c;

    public DaoSistema() {
    this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        Sistema sisEnt = (Sistema) obj;
        String sql = "INSERT INTO sistemas (nome, servidor, status, ip) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, sisEnt.getNome());
            stmt.setString(2, sisEnt.getServidor());
            stmt.setString(3, sisEnt.getStatus());
            stmt.setString(4, sisEnt.getIp());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    sisEnt.setId(rs.getInt(1));
                }
            }
        }
        return sisEnt;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        Sistema sisEnt = (Sistema) obj;
        String sql = "UPDATE sistemas SET nome = ?, servidor = ?, status = ?, ip = ? WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, sisEnt.getNome());
            stmt.setString(2, sisEnt.getServidor());
            stmt.setString(3, sisEnt.getStatus());
            stmt.setString(4, sisEnt.getIp());
            stmt.setInt(5, sisEnt.getId());

            stmt.executeUpdate();
        }
        return sisEnt;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM sistemas WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM sistemas WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Sistema(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("servidor"),
                        rs.getString("status"),
                        rs.getString("ip")
                    );
                }
            }
        }
        return null; // Não encontrou
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException {
        String sql = "SELECT * FROM sistemas WHERE nome LIKE ?";
        List<Object> lista = new ArrayList<>();

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, "%" + filtro + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Sistema sis = new Sistema(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("servidor"),
                        rs.getString("status"),
                        rs.getString("ip")
                    );
                    lista.add(sis);
                }
            }
        }
        return lista;
    }
}
