/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoSistema;
import reciclabackend.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerSistema implements ControllerBasico {
    
    DaoSistema dao;

  @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.inserir(obj);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.excluir(id);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.buscar(id);
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.listar(pfiltro);
    }

    
}
