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

import reciclabackend.model.bean.Municipio;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;
/**
 *
 * @author raife
 */
public class DaoMunicipio implements DaoBasico{

    private final Connection c;
	
	public DaoMunicipio() throws SQLException, ClassNotFoundException{
            this.c = ConexaoDb.getConexaoMySQL();
        }

	@Override
	public Object buscar(Object obj) {
		
            Municipio munEnt = (Municipio) obj; 

            try {			
                String sql = "SELECT * FROM MUN_MUNICIPIO WHERE COD = ?";
                PreparedStatement stmt = this.c.prepareStatement(sql);

                stmt.setInt(1, munEnt.getCodigo());

                ResultSet rs = stmt.executeQuery();
                Municipio munSaida = null;

                while (rs.next()) {      
                        munSaida = new Municipio(
                                        rs.getInt(1),
                                        rs.getString(2)
                                        );
                }

                stmt.close();

                return munSaida;
            }catch(SQLException e) {
                e.printStackTrace();
            }
            return null;
	}

	@Override
	public Object inserir(Object obj) {
            Municipio munEnt = (Municipio) obj;

            String sql = "INSERT INTO MUN_MUNICIPIO" + 
                                     "(COD, NOME)" + 
                                    " values (?, ?)";

            try {
                PreparedStatement stmt;

                stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


                stmt.setInt(1, munEnt.getCodigo());
                stmt.setString(2, munEnt.getNome());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next()) {
                    int id = rs.getInt(1);
                    munEnt.setId(id);
                }

                stmt.close();
                return munEnt;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
		
	}

	@Override
	public Object alterar(Object obj) {
            try {
                Municipio munEnt = (Municipio) obj;
                String sql = "UPDATE MUN_MUNICIPIO SET COD = ? NOME = ? WHERE ID = ?";

                // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql);

                // seta os valores
                stmt.setInt(1, munEnt.getCodigo());
                stmt.setString(2, munEnt.getNome());
                stmt.setInt(3, munEnt.getId());

                stmt.execute();
                stmt.close();

                return munEnt;
            }catch(SQLException e) {
                e.printStackTrace();
                return null;
            }
	}

	@Override
	public Boolean excluir(Object obj) {
            Municipio munEnt = (Municipio) obj; 

            try{
                String sql = "DELETE FROM MUN_MUNICIPIO WHERE ID = ?";

                // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql);

                // seta os valores
                stmt.setInt(1,munEnt.getId());

                // executa
                stmt.execute();
                stmt.close();

                c.close();
                return true;
            }catch(SQLException e) {
                e.printStackTrace();
                return false;
            }
	}

	@Override
	public List<Object> listar(Object obj){
            try{
                Municipio munEnt = (Municipio) obj;
                // usus: array armazena a lista de registros
                List<Object> cols = new ArrayList<>();

                String sql = "SELECT * FROM MUN_MUNICIPIO WHERE ID = ?";
                PreparedStatement stmt = this.c.prepareStatement(sql);

                // seta os valores
                stmt.setInt(1, munEnt.getId());

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {      

                    Municipio col = new Municipio(
                        rs.getInt(1),
                        rs.getString(2)
                    );

                    cols.add(col);
                }

                rs.close();
                stmt.close();
                return cols;
            }
            catch(SQLException e) {
                e.printStackTrace();
                return null;
            }
		
	}
    
}
