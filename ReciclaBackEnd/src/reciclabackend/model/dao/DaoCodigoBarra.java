package reciclabackend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import reciclabackend.model.bean.CodigoBarras;
import reciclabackend.model.bean.Colaborador;
import reciclabackend.util.DaoBasico;

public class DaoCodigoBarra implements DaoBasico {

    private final Connection c;

    public DaoCodigoBarra(Connection c) {
        this.c = c;
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
	CodigoBarras cbEnt = (CodigoBarras) obj;
		
		String sql = "INSERT INTO CODIGOBARRAS" + 
					 "(description, gtdin, brandName)" + 
				 	" values (?, ?, ?)";
		
		try {
			PreparedStatement stmt;
			
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		
			stmt.setString(1, cbEnt.getDescription());
			stmt.setString(1, cbEnt.getGtdin());
			stmt.setString(1, cbEnt.getBrandName());
			
			stmt.executeUpdate();
			
			stmt.close();
			return cbEnt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

    @Override
    public Object alterar(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public Object buscar(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

}
