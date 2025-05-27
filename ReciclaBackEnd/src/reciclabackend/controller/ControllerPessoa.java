/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

/**
 *
 * @author olgac
 */
import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoPessoa;
import reciclabackend.util.ControllerBasico;

public class ControllerPessoa implements ControllerBasico{
    DaoPessoa dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.listar(obj);
    }
    
    public List<Object> listarTodos()  throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.listarTodos();
    }
    
}

