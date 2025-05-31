package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reciclabackend.model.bean.Material;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

public class DaoMaterial implements DaoBasico {

    Connection c;

    public DaoMaterial() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        Material novoMaterial = (Material) obj;

        // query sql + prepared statement
        String sql = "insert into MAT_MATERIAL" + " (nome, descricao)" + " values (?,?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta valores da query no prepared statement
        stmt.setString(1, novoMaterial.getNome());
        stmt.setString(2, novoMaterial.getDescricao());

        stmt.executeUpdate();

        // recupera o id gerado
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            novoMaterial.setId(id);
        }
        stmt.close();
        return novoMaterial;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        Material materialEnt = (Material) obj;
        String sql = "UPDATE MAT_MATERIAL SET nome = ?, descricao = ? WHERE id = ?";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);

        // seta os valores
        stmt.setString(1, materialEnt.getNome());
        stmt.setString(2, materialEnt.getDescricao());
        stmt.setInt(3, materialEnt.getId());

        stmt.execute();
        stmt.close();
        return materialEnt;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "delete from MAT_MATERIAL WHERE id = " + Integer.toString(id);

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.execute();
        stmt.close();
        if (stmt.isCloseOnCompletion()) {
            c.close();
            return true;
        }
        c.close();
        return false;
    }

    @Override
    public Object buscar(int id) throws SQLException {
        String sql = "select * from MAT_MATERIAL where id = " + Integer.toString(id);

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);

        // executa e lista os resultados
        ResultSet rs = stmt.executeQuery();
        Material materialSaida = null;
        while (rs.next()) {
            materialSaida = new Material(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
        }
        stmt.close();
        return materialSaida;
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {

        List<Object> materiais = new ArrayList<>();

        String sql = "select * from MAT_MATERIAL where nome like " + pfiltro;

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);

        // executa e lista os resultados
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Material material = new Material(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            materiais.add(material);
        }
        stmt.close();
        return materiais;
    }

}