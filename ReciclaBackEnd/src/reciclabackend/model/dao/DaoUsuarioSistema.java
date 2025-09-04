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

public class DaoUsuarioSistema implements DaoBasico {

    private final Connection c;

    public DaoUsuarioSistema() {
         this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        UsuarioSistema usuEnt = (UsuarioSistema) obj;
        String sql = "INSERT INTO usuarios_sistemas (idU, idS, obs) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, usuEnt.getIdU());
            stmt.setInt(2, usuEnt.getIdS());
            stmt.setString(3, usuEnt.getObs());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    usuEnt.setId(rs.getInt(1));
                }
            }
        }
        return usuEnt;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        UsuarioSistema usuEnt = (UsuarioSistema) obj;
        String sql = "UPDATE usuarios_sistemas SET idU = ?, idS = ?, obs = ? WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, usuEnt.getIdU());
            stmt.setInt(2, usuEnt.getIdS());
            stmt.setString(3, usuEnt.getObs());
            stmt.setInt(4, usuEnt.getId());

            stmt.executeUpdate();
        }
        return usuEnt;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM usuarios_sistemas WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios_sistemas WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UsuarioSistema(
                        rs.getInt("id"),
                        rs.getInt("idU"),
                        rs.getInt("idS"),
                        rs.getString("obs")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException {
        String sql = "SELECT * FROM usuarios_sistemas WHERE obs LIKE ?";
        List<Object> lista = new ArrayList<>();

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, "%" + filtro + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    UsuarioSistema usu = new UsuarioSistema(
                        rs.getInt("id"),
                        rs.getInt("idU"),
                        rs.getInt("idS"),
                        rs.getString("obs")
                    );
                    lista.add(usu);
                }
            }
        }
        return lista;
    }
}
