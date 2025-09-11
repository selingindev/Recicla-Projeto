package reciclabackend.model.dao;
import java.sql.*;
import java.util.*;
import reciclabackend.model.bean.PessoaFisica;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoPessoaFisica implements DaoBasico {

    @Override
    public Object inserir(Object obj) throws SQLException {
        PessoaFisica pf = (PessoaFisica) obj;
        String sql = "INSERT INTO pef_pessoafisica (idpes, cpf, rg) VALUES (?, ?, ?)";

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, pf.getIdPes());
        ps.setString(2, pf.getCpf());
        ps.setString(3, pf.getRg());
        ps.executeUpdate();

        return pf;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        PessoaFisica pf = (PessoaFisica) obj;
        String sql = "UPDATE pef_pessoafisica SET cpf = ?, rg = ? WHERE idpes = ?";

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, pf.getCpf());
        ps.setString(2, pf.getRg());
        ps.setInt(3, pf.getIdPes());
        ps.executeUpdate();

        return pf;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM pef_pessoafisica WHERE idpes = ?";

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        int linhasAfetadas = ps.executeUpdate();

        return linhasAfetadas > 0;
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "SELECT * FROM pef_pessoafisica WHERE idpes = ?";
        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            PessoaFisica pf = new PessoaFisica();
            pf.setIdPes(rs.getInt("idpes"));
            pf.setCpf(rs.getString("cpf"));
            pf.setRg(rs.getString("rg"));
            return pf;
        }

        return null;
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        String sql = "SELECT * FROM pef_pessoafisica";
        if (pfiltro != null && !pfiltro.trim().isEmpty()) {
            sql += " WHERE cpf LIKE ? OR rg LIKE ?";
        }

        Connection conexao = ConexaoDb.getConexaoMySQL();
        PreparedStatement ps = conexao.prepareStatement(sql);

        if (pfiltro != null && !pfiltro.trim().isEmpty()) {
            String filtro = "%" + pfiltro + "%";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
        }

        ResultSet rs = ps.executeQuery();
        List<Object> lista = new ArrayList<>();

        while (rs.next()) {
            PessoaFisica pf = new PessoaFisica();
            pf.setIdPes(rs.getInt("idpes"));
            pf.setCpf(rs.getString("cpf"));
            pf.setRg(rs.getString("rg"));
            lista.add(pf);
        }

        return lista;
    }
}
