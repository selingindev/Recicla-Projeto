package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoMaterial;
import reciclabackend.util.ControllerBasico;

public class ControllerMaterial implements ControllerBasico {
    DaoMaterial dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.excluir(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.buscar(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.listar(obj);
    }
}
