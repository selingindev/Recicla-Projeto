package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoValorCredito;
import reciclabackend.util.ControllerBasico;

public class ControllerValorCredito implements ControllerBasico {

	DaoValorCredito dao;
	@Override
	public Object buscar(int id) throws SQLException , ClassNotFoundException {
            dao = new DaoValorCredito();
            return dao.buscar(id);
	}

	@Override
	public Object inserir(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoValorCredito();
            return dao.inserir(obj);
	}

	@Override
	public Object alterar(Object obj) throws SQLException , ClassNotFoundException {
            dao = new DaoValorCredito();
            return dao.alterar(obj);
	}

	@Override
	public boolean excluir(int id) throws SQLException , ClassNotFoundException {
            dao = new DaoValorCredito();
	    return dao.excluir(id);
	}

	@Override
	public List<Object> listar(String filtro) throws SQLException , ClassNotFoundException {
            dao = new DaoValorCredito();
            return dao.listar(filtro);
	}

}
