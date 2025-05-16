/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.controller;

import java.sql.SQLException;
import java.util.List;

import recicla.model.dao.DaoParametro;
import recicla.util.ControllerBasico;

public class ControllerParametro implements ControllerBasico{
    
    DaoParametro dao;
	@Override
	public Object buscar(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
            return dao.buscar(obj);
	}

	@Override
	public Object inserir(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
            return dao.inserir(obj);
	}

	@Override
	public Object alterar(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
            return dao.alterar(obj);
	}

	@Override
	public Boolean excluir(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
	    return dao.excluir(obj);
	}

	@Override
	public List<Object> listar(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
            return dao.listar(obj);
	}
}
