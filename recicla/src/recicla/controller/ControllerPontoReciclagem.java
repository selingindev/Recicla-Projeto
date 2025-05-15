/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.controller;

import java.sql.SQLException;
import java.util.List;
import recicla.model.bean.PontoReciclagem;
import recicla.model.dao.DaoPontoReciclagem;
import recicla.util.ControllerBasico;

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
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        return dao.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPontoReciclagem();
        List<Object> lista = dao.listar(obj);
        System.out.println(lista);
        return lista;
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
