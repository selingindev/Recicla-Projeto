package reciclabackend.model.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import reciclabackend.model.bean.Logradouro;
import reciclabackend.util.ConexaoDb;
import reciclabackend.util.DaoBasico;
 
public class DaoLogradouro implements DaoBasico{
 
    private final Connection c;
 
    public DaoLogradouro() throws SQLException, ClassNotFoundException{
          this.c = ConexaoDb.getConexaoMySQL();
    }
 
    @Override
    public Object inserir(Object obj) throws SQLException {
        Logradouro logradouro = (Logradouro) obj;
 
        String sql = "insert into LOG_LOGRADOURO" + " (cep, numero, complemento_api, complemento_outros)" + " values (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, logradouro.getCep());
        stmt.setString(2, logradouro.getNumero());
        stmt.setString(3, logradouro.getComplementoApi());
        stmt.setString(4, logradouro.getComplementoOutros());
 
          // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            logradouro.setId(id);
        }
        stmt.close();
        return logradouro;
    }
 
    @Override
    public Object alterar(Object obj) throws SQLException {
        Logradouro logradouro = (Logradouro) obj; 
        String sql = "UPDATE LOG_LOGRADOURO SET cep = ?, numero = ?, complemento_api = ?, complemento_outros = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, logradouro.getCep());
        stmt.setString(2, logradouro.getNumero());
        stmt.setString(3, logradouro.getComplementoApi());
        stmt.setString(4, logradouro.getComplementoOutros());
        stmt.setInt(5, logradouro.getId());
        stmt.execute();
        stmt.close();
 
        return logradouro;
        }   
 
    @Override
    public Object excluir(Object obj) throws SQLException {
        Logradouro logradouro = (Logradouro) obj; 
        String sql = "delete from LOG_LOGRADOURO WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, logradouro.getId());
        stmt.execute();
        stmt.close();
        return logradouro;
       }
 
    @Override
    public Object buscar(Object obj) throws SQLException {
        Logradouro logradouro = (Logradouro) obj; 
        String sql = "select * from LOG_LOGRADOURO WHERE cep = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
 
        stmt.setInt(1, logradouro.getId());
            ResultSet rs = stmt.executeQuery();
            Logradouro logSaida = null;
            while (rs.next()) {      
                logSaida = new Logradouro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            }
            stmt.close();
        return logSaida;
           }
 
     @Override
    public List<Object> listar(Object obj) throws SQLException  {
        Logradouro logradouroEntrada = (Logradouro) obj;
        List<Object> logts = new ArrayList<>();
        String sql = "select * from LOG_LOGRADOURO where cep like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + logradouroEntrada.getCep() + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {      
            Logradouro logradouro = new Logradouro(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
                );
            logts.add(logradouro);
        }
        rs.close();
        stmt.close();
        return logts;
    }
}