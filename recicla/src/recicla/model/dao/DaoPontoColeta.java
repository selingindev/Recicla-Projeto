package recicla.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import recicla.model.bean.PontoColeta;
import recicla.util.ConexaoDb;
import recicla.util.DaoBasico;

public class DaoPontoColeta implements DaoBasico {

    private final Connection c;

    public DaoPontoColeta() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        PontoColeta ponto = (PontoColeta) obj;
        String sql = "INSERT INTO PON_PONTOCOLETA (nome, id_log, qr_code) VALUES (?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, ponto.getNome());
        stmt.setString(2, ponto.getIdLog());
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
        String sql = "UPDATE PON_PONTOCOLETA SET nome = ?, id_log = ?, qr_code = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, ponto.getNome());
        stmt.setString(2, ponto.getIdLog());
        stmt.setString(3, ponto.getQrCode());
        stmt.setInt(4, ponto.getId());
        stmt.executeUpdate();
        stmt.close();
        return ponto;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        PontoColeta ponto = (PontoColeta) obj;
        String sql = "DELETE FROM PON_PONTOCOLETA WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, ponto.getId());
        stmt.executeUpdate();
        stmt.close();
        return ponto;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        PontoColeta ponto = (PontoColeta) obj;
        String sql = "SELECT * FROM PON_PONTOCOLETA WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, ponto.getId());
        ResultSet rs = stmt.executeQuery();
        PontoColeta pontoEncontrado = null;
        if (rs.next()) {
            pontoEncontrado = new PontoColeta(
                rs.getInt("id"),
                rs.getString("id_log"),
                rs.getString("nome"),
                rs.getString("qr_code")
            );
        }
        rs.close();
        stmt.close();
        return pontoEncontrado;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException {
        PontoColeta pontoFiltro = (PontoColeta) obj;
        List<Object> pontos = new ArrayList<>();
        String sql = "SELECT * FROM PON_PONTOCOLETA WHERE nome LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, "%" + pontoFiltro.getNome() + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            PontoColeta ponto = new PontoColeta(
                rs.getInt("id"),
                rs.getString("id_log"),
                rs.getString("nome"),
                rs.getString("qr_code")
            );
            pontos.add(ponto);
        }

        rs.close();
        stmt.close();
        return pontos;
    }
}