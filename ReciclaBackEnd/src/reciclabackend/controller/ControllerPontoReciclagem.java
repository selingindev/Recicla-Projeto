/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.bean.PontoReciclagem;
import reciclabackend.model.dao.DaoPontoReciclagem;
import reciclabackend.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerPontoReciclagem implements ControllerBasico {
    
    DaoPontoReciclagem dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        return dao.buscar(id);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        return dao.excluir(id);
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        return dao.listar(pfiltro);
    }

    public boolean validar(PontoReciclagem usuEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        dao = new DaoPontoReciclagem();
        PontoReciclagem idSaida = dao.validar(usuEnt);
        if(idSaida != null) {
            retorno = true;
        }
        return retorno;
    }

    public PontoReciclagem validarWeb(PontoReciclagem idEnt) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        PontoReciclagem usuSaida = dao.validar(idEnt);
        return usuSaida;
    }



}
