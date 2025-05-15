/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.controller;

import java.sql.SQLException;
import java.util.List;
import recicla.model.bean.Usuario;
import recicla.model.dao.DaoUsuario;
import recicla.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerUsuario implements ControllerBasico {
    
    DaoUsuario dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.listar(obj);
    }

    public boolean validar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        dao = new DaoUsuario();
        Usuario usuSaida = dao.validar(usuEnt);
        if(usuSaida != null) {
            retorno = true;
        }
        return retorno;
    }

    public Usuario validarWeb(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        Usuario usuSaida = dao.validar(usuEnt);
        return usuSaida;
    }



}
