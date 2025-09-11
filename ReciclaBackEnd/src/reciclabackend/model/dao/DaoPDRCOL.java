
package reciclabackend.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import reciclabackend.model.bean.PdrCol;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;


public class DaoPDRCOL implements DaoBasico {

    private final Connection c;

    public DaoPDRCOL() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    private PdrCol mapear(ResultSet rs) throws SQLException {
        return new PdrCol(
                rs.getInt("id"),
                rs.getInt("id_pdr"),
                rs.getInt("id_col")
        );
    }

    public PdrCol validar(PdrCol entidade) throws SQLException {
        String sql = "SELECT * FROM PDR_COL WHERE id_pdr = ? AND id_col = ?";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, entidade.getIdPRD());
            stmt.setInt(2, entidade.getIdCOL());
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        }
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        PdrCol entidade = (PdrCol) obj;
        String sql = "INSERT INTO PDR_COL (id_pdr, id_col) VALUES (?, ?)";
        try (PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, entidade.getIdPRD());
            stmt.setInt(2, entidade.getIdCOL());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) entidade.setId(rs.getInt(1));
            }
        }
        return entidade;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        PdrCol entidade = (PdrCol) obj;
        String sql = "UPDATE PDR_COL SET id_pdr = ?, id_col = ? WHERE id = ?";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, entidade.getIdPRD());
            stmt.setInt(2, entidade.getIdCOL());
            stmt.setInt(3, entidade.getId());
            stmt.executeUpdate();
        }
        return entidade;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM PDR_COL WHERE id = ?";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        return true;
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM PDR_COL WHERE id = ?";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        }
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        List<Object> lista = new ArrayList<>();
        String sql = pfiltro == null || pfiltro.isEmpty() 
                     ? "SELECT * FROM PDR_COL" 
                     : "SELECT * FROM PDR_COL WHERE id_pdr LIKE ?";
        
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            if (pfiltro != null && !pfiltro.isEmpty()) {
                stmt.setString(1, "%" + pfiltro + "%");
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }
}
