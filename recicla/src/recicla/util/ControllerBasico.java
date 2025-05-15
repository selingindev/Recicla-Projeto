/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.util;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LAB 211
 */
public interface ControllerBasico {
    
    public Object inserir(Object obj) throws SQLException , ClassNotFoundException;
    public Object alterar(Object obj) throws SQLException , ClassNotFoundException;
    public Object excluir(Object obj) throws SQLException , ClassNotFoundException;
    public Object buscar(Object obj) throws SQLException , ClassNotFoundException;
    public List<Object> listar(Object obj) throws SQLException , ClassNotFoundException;

}
