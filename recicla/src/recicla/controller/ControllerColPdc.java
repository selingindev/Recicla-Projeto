/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.controller;

import java.sql.SQLException;
import java.util.List;
import recicla.model.dao.DaoColPdc;
import recicla.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerColPdc implements ControllerBasico {

    DaoColPdc dao; 


    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.listar(obj);
    }
}
