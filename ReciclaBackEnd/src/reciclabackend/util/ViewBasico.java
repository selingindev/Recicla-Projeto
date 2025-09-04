/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.util;

import java.sql.SQLException;

/**
 *
 * @author LAB 211
 */
public interface ViewBasico {
    
    public void menu() throws SQLException, ClassNotFoundException;
    public void inserir() throws SQLException , ClassNotFoundException;
    public void alterar() throws SQLException , ClassNotFoundException;
    public void excluir() throws SQLException , ClassNotFoundException;
    public void buscar() throws SQLException , ClassNotFoundException;
    public void listar() throws SQLException , ClassNotFoundException;
    
}
