package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.dao.DaoPEF_PDC;
import reciclabackend.util.ControllerBasico;

public class ControllerPEF_PDC implements ControllerBasico {

    private final DaoPEF_PDC dao;

    public ControllerPEF_PDC() throws SQLException, ClassNotFoundException {
        this.dao = new DaoPEF_PDC();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        return dao.alterar(obj);
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        return dao.excluir(id);
    }

    @Override
    public Object buscar(int id) throws SQLException {
        return dao.buscar(id);
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException {
        return dao.listar(filtro);
    }
}