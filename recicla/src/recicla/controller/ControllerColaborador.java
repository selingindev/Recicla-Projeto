package recicla.controller;

import java.sql.SQLException;
import java.util.List;

import recicla.model.dao.DaoColaborador;
import recicla.util.ControllerBasico;

public class ControllerColaborador implements ControllerBasico {

	DaoColaborador dao;
	@Override
	public Object buscar(Object obj) throws SQLException , ClassNotFoundException {
		dao = new DaoColaborador();
        return dao.buscar(obj);
	}

	@Override
	public Object inserir(Object obj) throws SQLException , ClassNotFoundException {
		dao = new DaoColaborador();
        return dao.inserir(obj);
	}

	@Override
	public Object alterar(Object obj) throws SQLException , ClassNotFoundException {
		dao = new DaoColaborador();
        return dao.alterar(obj);
	}

	@Override
	public Boolean excluir(Object obj) throws SQLException , ClassNotFoundException {
		dao = new DaoColaborador();
	    return dao.excluir(obj);
	}

	@Override
	public List<Object> listar(Object obj) throws SQLException , ClassNotFoundException {
		dao = new DaoColaborador();
        return dao.listar(obj);
	}

}
