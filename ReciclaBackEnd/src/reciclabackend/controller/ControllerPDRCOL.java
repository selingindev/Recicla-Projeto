/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.bean.PdrCol;
import reciclabackend.model.dao.DaoPDRCOL;
import reciclabackend.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerPDRCOL implements ControllerBasico {
    
    DaoPDRCOL dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPDRCOL();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPDRCOL();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPDRCOL();
        return dao.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPDRCOL();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPDRCOL();
        return dao.listar(obj);
    }

    public boolean validar(PdrCol usuEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        dao = new DaoPDRCOL();
        PdrCol usuSaida = dao.validar(usuEnt);
        if(usuSaida != null) {
            retorno = true;
        }
        return retorno;
    }

    public PdrCol validarWeb(PdrCol usuEnt) throws SQLException, ClassNotFoundException {
        dao = new DaoPDRCOL();
        PdrCol usuSaida = dao.validar(usuEnt);
        return usuSaida;
    }



}
