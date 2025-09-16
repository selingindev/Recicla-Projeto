package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoMunicipio;
import reciclabackend.util.ControllerBasico;

public class ControllerMunicipio implements ControllerBasico {

	DaoMunicipio dao;
	@Override
	public Object buscar(int cod) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
            return dao.buscar(cod);
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
	public boolean excluir(int id) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
	    return dao.excluir(id);
	}

	@Override
	public List<Object> listar(String filtro) throws SQLException , ClassNotFoundException {
            dao = new DaoMunicipio();
            return dao.listar(filtro);
	}

}
