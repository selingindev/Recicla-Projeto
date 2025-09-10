package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reciclabackend.model.bean.Usuario;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoUsuario implements DaoBasico {

    private final Connection c;

    public DaoUsuario() {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Usuario validar(Usuario usuEnt) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1, usuEnt.getLogin());
            stmt.setString(2, usuEnt.getSenha());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getString("status"),
                            rs.getString("tipo"));
                }
            }
        }
        return null;
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        Usuario usuEnt = (Usuario) obj;
        String sql = "INSERT INTO usuarios (login, senha, status, tipo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuEnt.getLogin());
            stmt.setString(2, usuEnt.getSenha());
            stmt.setString(3, usuEnt.getStatus());
            stmt.setString(4, usuEnt.getTipo());

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
        Usuario usuEnt = (Usuario) obj;
        String sql = "UPDATE usuarios SET login = ?, senha = ?, status = ?, tipo = ? WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, usuEnt.getLogin());
            stmt.setString(2, usuEnt.getSenha());
            stmt.setString(3, usuEnt.getStatus());
            stmt.setString(4, usuEnt.getTipo());
            stmt.setInt(5, usuEnt.getId());

            stmt.executeUpdate();
        }
        return usuEnt;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getString("status"),
                            rs.getString("tipo"));
                }
            }
        }
        return null;
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE login LIKE ?";
        List<Object> lista = new ArrayList<>();

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, "%" + filtro + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Usuario usu = new Usuario(
                            rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getString("status"),
                            rs.getString("tipo"));
                    lista.add(usu);
                }
            }
        }
        return lista;
    }
}
