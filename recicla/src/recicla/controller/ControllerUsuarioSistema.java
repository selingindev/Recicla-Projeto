/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import recicla.model.bean.Sistema;
import recicla.model.bean.Usuario;
import recicla.model.bean.UsuarioSistema;
import recicla.model.dao.DaoUsuarioSistema;
import recicla.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerUsuarioSistema implements ControllerBasico {
    
    DaoUsuarioSistema dao;
    ControllerUsuario contUsu;
    ControllerSistema contSis;
    
    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();
        return dao.excluir(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();
        UsuarioSistema objSaida = (UsuarioSistema) dao.buscar(obj);
        Object usu = new Usuario(objSaida.getIdU());
        Object sis = new Sistema(objSaida.getIdS());
        contUsu = new ControllerUsuario();
        contSis = new ControllerSistema();
        objSaida.setUsu(contUsu.buscar(usu));
        objSaida.setSis(contSis.buscar(sis));
        return objSaida;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();
        List<Object> listaAux = dao.listar(obj);
        List<Object> lista = new ArrayList<>();
        for (Object objlista : listaAux) {
            lista.add(buscar(objlista));
        }
        return lista;
     }
    
}
