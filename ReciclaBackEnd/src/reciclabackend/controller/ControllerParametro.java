/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoParametro;
import reciclabackend.util.ControllerBasico;

public class ControllerParametro implements ControllerBasico{
    
    DaoParametro dao;
	@Override
	public Object buscar(int cod) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
            return dao.buscar(cod);
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
	public boolean excluir(int id) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
	    return dao.excluir(id);
	}

	@Override
	public List<Object> listar(String filtro) throws SQLException , ClassNotFoundException {
            dao = new DaoParametro();
            return dao.listar(filtro);
	}
}
