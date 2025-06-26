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

import reciclabackend.model.bean.ValorGame;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;
/**
 *
 * @author raife
 */
public class DaoValorGame implements DaoBasico{

    private final Connection c;
	
	public DaoValorGame() throws SQLException, ClassNotFoundException{
            this.c = ConexaoDb.getConexaoMySQL();
        }

	@Override
	public Object buscar(int id) {

            try {			
                String sql = "SELECT * FROM VLG-VALOR_GAME WHERE ID = ?";
                PreparedStatement stmt = this.c.prepareStatement(sql);

                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                ValorGame valorSaida = null;

                while (rs.next()) {      
                        valorSaida = new ValorGame(
                            rs.getInt(1),
                            rs.getDouble(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getInt(6)
                        );
                }

                stmt.close();

                return valorSaida;
            }catch(SQLException e) {
                e.printStackTrace();
            }
            return null;
	}

	@Override
	public Object inserir(Object obj) {
            ValorGame valorEnt = (ValorGame) obj;

            String sql = "INSERT INTO VLG-VALOR_GAME" + 
                                     "(ID, VALOR, NIVEL, ID_MAT, ID_PAR, ID_MUNI)" + 
                                    " values (?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement stmt;

                stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


                stmt.setInt(1, valorEnt.getId());
                stmt.setDouble(2, valorEnt.getValor());
                stmt.setInt(3, valorEnt.getNivel());
                stmt.setInt(4, valorEnt.getIdMat());
                stmt.setInt(5, valorEnt.getIdPar());
                stmt.setInt(6, valorEnt.getIdMuni());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next()) {
                    int id = rs.getInt(1);
                    valorEnt.setId(id);
                }

                stmt.close();
                return valorEnt;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
		
	}

	@Override
	public Object alterar(Object obj) {
            try {
                ValorGame valorEnt = (ValorGame) obj;
                String sql = "UPDATE VLG-VALOR_GAME SET VAlOR = ?, NIVEL = ? WHERE ID = ?";

                // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql);

                // seta os valores
                stmt.setDouble(1, valorEnt.getValor());
                stmt.setInt(2, valorEnt.getNivel());
                stmt.setInt(3, valorEnt.getId());

                stmt.execute();
                stmt.close();

                return valorEnt;
            }catch(SQLException e) {
                e.printStackTrace();
                return null;
            }
	}

	@Override
	public boolean excluir(int id) { 

            try{
                String sql = "DELETE FROM VLG-VALOR_GAME WHERE ID = ?";

                // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql);

                // seta os valores
                stmt.setInt(1,id);

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
	public List<Object> listar(String filtro){
            try{
                // usus: array armazena a lista de registros
                List<Object> valores = new ArrayList<>();

                String sql = "SELECT * FROM VLG-VALOR_GAME WHERE VALOR = ?";
                PreparedStatement stmt = this.c.prepareStatement(sql);

                // seta os valores
                stmt.setString(1, filtro); // Erro

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {      

                    ValorGame col = new ValorGame(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                    );

                    valores.add(col);
                }

                rs.close();
                stmt.close();
                return valores;
            }
            catch(SQLException e) {
                e.printStackTrace();
                return null;
            }
		
	}
    
}
