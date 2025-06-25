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
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.excluir(id);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.buscar(id);
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException, ClassNotFoundException {
        dao = new DaoMaterial();
        return dao.listar(pfiltro);
    }
}