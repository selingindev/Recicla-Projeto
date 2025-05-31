/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.bean.PessoaJuridica;
import reciclabackend.model.dao.DaoPessoaJuridica;
import reciclabackend.util.ControllerBasico;

/**
 *
 * @author olgac
 */
public class ControllerPessoaJuridica implements ControllerBasico {
    DaoPessoaJuridica dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaJuridica();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaJuridica();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaJuridica();
        return dao.buscar(id);
    }

    @Override
    public Boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaJuridica();
        return dao.excluir(id);
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaJuridica();
        return dao.listar(pfiltro);
    }
}
