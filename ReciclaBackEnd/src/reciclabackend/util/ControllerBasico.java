/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.util;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LAB 211
 */
public interface ControllerBasico {
    
    public Object inserir(Object obj) throws SQLException , ClassNotFoundException;
    public Object alterar(Object obj) throws SQLException , ClassNotFoundException;
    public boolean excluir(int id) throws SQLException , ClassNotFoundException;
    public Object buscar(int id) throws SQLException , ClassNotFoundException;
    public List<Object> listar(String pfiltro) throws SQLException , ClassNotFoundException;

}
