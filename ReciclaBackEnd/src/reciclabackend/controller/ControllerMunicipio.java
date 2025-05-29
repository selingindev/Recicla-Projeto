package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoMunicipio;
import reciclabackend.util.ControllerBasico;

public class ControllerMunicipio implements ControllerBasico {

	DaoMunicipio dao;
	@Override
	public Object buscar(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
            return dao.buscar(obj);
	}

	@Override
	public Object inserir(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
            return dao.inserir(obj);
	}

	@Override
	public Object alterar(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
            return dao.alterar(obj);
	}

	@Override
	public Boolean excluir(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
	    return dao.excluir(obj);
	}

	@Override
	public List<Object> listar(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
            return dao.listar(obj);
	}

}
