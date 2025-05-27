/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.dao.DaoColPdc;
import reciclabackend.util.ControllerBasico;

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
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.buscar(id);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.excluir(id);
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException, ClassNotFoundException {
        dao = new DaoColPdc();
        return dao.listar(pfiltro);
    }
}
