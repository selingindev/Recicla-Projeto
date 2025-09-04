package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.bean.PontoColeta;
import reciclabackend.model.dao.DaoPontoColeta;
import reciclabackend.util.ControllerBasico;

public class ControllerPontoColeta implements ControllerBasico {

    DaoPontoColeta dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        PontoColeta ponto = (PontoColeta) obj;
        dao = new DaoPontoColeta();
        return dao.inserir(ponto);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        PontoColeta ponto = (PontoColeta) obj;
        dao = new DaoPontoColeta();
        return dao.alterar(ponto);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoColeta();
        return dao.excluir(id);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoColeta();
        return dao.buscar(id);
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoColeta();
        return dao.listar(filtro);
    }
}
