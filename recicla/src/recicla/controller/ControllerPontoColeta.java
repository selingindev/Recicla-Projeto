/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.controller;

import java.sql.SQLException;
import java.util.List;
import recicla.model.bean.PontoColeta;
import recicla.model.dao.DaoPontoColeta;
import recicla.util.ControllerBasico;

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
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        PontoColeta ponto = (PontoColeta) obj;
        dao = new DaoPontoColeta();
        return dao.excluir(ponto);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        PontoColeta ponto = (PontoColeta) obj;
        dao = new DaoPontoColeta();
        return dao.buscar(ponto);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoColeta();
        return dao.listar(obj);
    }
}