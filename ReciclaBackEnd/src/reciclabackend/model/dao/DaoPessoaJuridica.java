/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reciclabackend.model.bean.PessoaJuridica;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;

/**
 *
 * @author olgac
 */
public class DaoPessoaJuridica  implements DaoBasico{
    
    Connection c;

    public DaoPessoaJuridica() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

   @Override
    public Object inserir(Object obj) throws SQLException {
        PessoaJuridica pj = (PessoaJuridica) obj;
        String sql = "INSERT INTO pej_pessoajuridica (idpes, cnpj, insc_est) VALUES (?, ?, ?)";
        
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, pj.getIdPes());
        stmt.setString(2, pj.getCnpj());
        stmt.setString(3, pj.getInscEst());
        stmt.executeUpdate();
        
        ResultSet rs = stmt.getGeneratedKeys();
			
            if(rs.next()) {
		int id = rs.getInt(1);
		pj.setId(id);
            }
			
	stmt.close();
	return pj;
    }

    @Override
    public Object alterar(Object obj) throws SQLException{
        PessoaJuridica pj = (PessoaJuridica) obj;
        String sql = "UPDATE pej_pessoajuridica SET IDPES = ?, CNPJ = ?, INSC_EST = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pj.getIdPes());
        stmt.setString(2,pj.getCnpj());
        stmt.setString(3,pj.getInscEst());
        stmt.setInt(4,pj.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pj;
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
    List<Object> usus = new ArrayList<>();

    String sql = "SELECT * FROM pej_pessoajuridica WHERE cnpj LIKE ?";
    PreparedStatement stmt = this.c.prepareStatement(sql);
    stmt.setString(1, "%" + pfiltro + "%");

    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        PessoaJuridica usu = new PessoaJuridica(
            rs.getInt("id"),
            rs.getInt("idpes"),
            rs.getString("cnpj"),
            rs.getString("insc_est")
        );
        usus.add(usu);
    }

        rs.close();
        stmt.close();
        return usus;
    }


    @Override
    public boolean excluir(int id) throws SQLException {
    String sql = "DELETE FROM pej_pessoajuridica WHERE id = ?";
    PreparedStatement stmt = c.prepareStatement(sql);
    stmt.setInt(1, id);
    stmt.execute();
    stmt.close();
    return true;
    }

    
    @Override
    public Object buscar(int id) throws SQLException {
    String sql = "SELECT * FROM pej_pessoajuridica WHERE id = ?";
    PreparedStatement stmt = this.c.prepareStatement(sql);
    stmt.setInt(1, id);
    ResultSet rs = stmt.executeQuery();
    PessoaJuridica pessoSaida = null;

    if (rs.next()) {
        pessoSaida = new PessoaJuridica(
            rs.getInt(1),
            rs.getInt(2),
            rs.getString(3),
            rs.getString(4)
        );
    }

    rs.close();
    stmt.close();
    return pessoSaida;
 }

    
}
