package recicla.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import recicla.util.ConexaoDb;
import recicla.util.DaoBasico;
import recicla.model.bean.Colaborador;

public class DaoColaborador implements DaoBasico {

	private final Connection c;
	
	public DaoColaborador() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

	@Override
	public Object buscar(Object obj) {
		
		Colaborador colEnt = (Colaborador) obj; 
       
		try {			
			String sql = "SELECT * FROM COL_COLABORADOR WHERE ID = ?";
			PreparedStatement stmt = this.c.prepareStatement(sql);
			
			stmt.setInt(1, colEnt.getId());
			
			ResultSet rs = stmt.executeQuery();
			Colaborador colSaida = null;
			
			while (rs.next()) {      
				colSaida = new Colaborador(
						rs.getInt(1),
						rs.getInt(2)
						);
			}
			
			stmt.close();
			
			return colSaida;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object inserir(Object obj) {
		Colaborador colEnt = (Colaborador) obj;
		
		String sql = "INSERT INTO COL_COLABORADOR" + 
					 "(ID, FUNCIONAL)" + 
				 	" values (?, ?)";
		
		try {
			PreparedStatement stmt;
			
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		
			stmt.setLong(1, colEnt.getId());
			stmt.setLong(2, colEnt.getFuncional());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				colEnt.setId(id);
			}
			
			stmt.close();
			return colEnt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Object alterar(Object obj) {
		try {
			Colaborador colEnt = (Colaborador) obj;
			String sql = "UPDATE COL_COLABORADOR SET FUNCIONAL = ? WHERE ID = ?";
			
			// prepared statement para inserção
			PreparedStatement stmt = c.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,colEnt.getFuncional());
			stmt.setInt(2,colEnt.getId());
			
			stmt.execute();
			stmt.close();
			
			return colEnt;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean excluir(Object obj) {
		Colaborador colEnt = (Colaborador) obj; 
		
		try{
			String sql = "DELETE FROM COL_COLABORADOR WHERE ID = ?";

			// prepared statement para inserção
			PreparedStatement stmt = c.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,colEnt.getId());
			
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
			Colaborador colEnt = (Colaborador) obj;
			// usus: array armazena a lista de registros
			List<Object> cols = new ArrayList<>();
			
			String sql = "SELECT * FROM COL_COLABORADOR WHERE ID = ?";
			PreparedStatement stmt = this.c.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1, colEnt.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {      
				
				Colaborador col = new Colaborador(
						rs.getInt(1),
						rs.getInt(2)
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
