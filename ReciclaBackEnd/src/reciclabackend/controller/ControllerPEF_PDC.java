package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.dao.DaoPEF_PDC;
import reciclabackend.util.ControllerBasico;

public class ControllerPEF_PDC implements ControllerBasico {

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        DaoPEF_PDC dao = new DaoPEF_PDC();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        DaoPEF_PDC dao = new DaoPEF_PDC();
        return dao.alterar(obj);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        DaoPEF_PDC dao = new DaoPEF_PDC();
        return dao.excluir(id);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        DaoPEF_PDC dao = new DaoPEF_PDC();
        return dao.buscar(id);
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException, ClassNotFoundException {
        DaoPEF_PDC dao = new DaoPEF_PDC();
        return dao.listar(filtro);
    }
}