/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import recicla.model.bean.PessoaJuridica;
import recicla.util.ConexaoDb;
import recicla.util.DaoBasico;

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
    public List<Object> listar(Object obj) throws SQLException{
        PessoaJuridica pj = (PessoaJuridica) obj;
        // usus: array armazena a lista de registros
        List<Object> usus = new ArrayList<>();
        
        String sql = "select * from pej_pessoajuridica where cnpj like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pj.getCnpj()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoaJuridica usu = new PessoaJuridica(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
   }

    @Override
    public Object excluir(Object obj) throws SQLException{
        PessoaJuridica pj = (PessoaJuridica) obj;
        String sql = "delete from pej_pessoajuridica WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pj.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pj;
    }
    
    @Override
    public Object buscar(Object obj) throws SQLException{
        PessoaJuridica pj = (PessoaJuridica) obj;
        String sql = "select * from pej_pessoajuridica WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pj.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoaJuridica pessoSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pessoSaida = new PessoaJuridica(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pessoSaida;
   }
    
}
