package recicla.controller;

import java.sql.SQLException;
import java.util.List;
import recicla.model.dao.DaoPEF_PDC;
import recicla.util.ControllerBasico;

public class ControllerPEF_PDC implements ControllerBasico {

    private DaoPEF_PDC dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPEF_PDC();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPEF_PDC();
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPEF_PDC();
        return dao.excluir(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPEF_PDC();
        return dao.buscar(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPEF_PDC();
        return dao.listar(obj);
    }
}
