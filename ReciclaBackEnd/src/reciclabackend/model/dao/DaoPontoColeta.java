package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reciclabackend.model.bean.PontoColeta;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoPontoColeta implements DaoBasico {

    private final Connection c;

    public DaoPontoColeta() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        PontoColeta ponto = (PontoColeta) obj;
        String sql = "INSERT INTO pdc_ponto_coleta (nome, id_log, qrcode) VALUES (?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, ponto.getNome());
        stmt.setInt(2, ponto.getIdLog());
        stmt.setString(3, ponto.getQrCode());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            ponto.setId(id);
        }
        stmt.close();
        return ponto;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        PontoColeta ponto = (PontoColeta) obj;
        String sql = "UPDATE pdc_ponto_coleta SET nome = ?, id_log = ?, qrcode = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, ponto.getNome());
        stmt.setInt(2, ponto.getIdLog());
        stmt.setString(3, ponto.getQrCode());
        stmt.setInt(4, ponto.getId());
        stmt.executeUpdate();
        stmt.close();
        return ponto;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM pdc_ponto_coleta WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        stmt.close();
        return rows > 0;
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM pdc_ponto_coleta WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        PontoColeta ponto = null;
        if (rs.next()) {
            ponto = new PontoColeta(
                rs.getInt("id"),
                rs.getInt("id_log"),
                rs.getString("nome"),
                rs.getString("qrcode")
            );
        }
        rs.close();
        stmt.close();
        return ponto;
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException {
        List<Object> pontos = new ArrayList<>();
        String sql = "SELECT * FROM pdc_ponto_coleta WHERE nome LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, "%" + filtro + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            PontoColeta ponto = new PontoColeta(
                rs.getInt("id"),
                rs.getInt("id_log"),
                rs.getString("nome"),
                rs.getString("qrcode")
            );
            pontos.add(ponto);
        }

        rs.close();
        stmt.close();
        return pontos;
    }
}
