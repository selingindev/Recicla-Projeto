/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.dao.DaoPessoaJuridica;
import reciclabackend.util.ControllerBasico;

/**
 *
 * @author olgac
 */
public class ControllerPessoaJuridica implements ControllerBasico {
    DaoPessoaJuridica dao;

    public ControllerPessoaJuridica() throws SQLException, ClassNotFoundException {
        this.dao = new DaoPessoaJuridica();
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
    public Object buscar(int id) throws SQLException {
        return dao.buscar(id);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        boolean resultado = dao.excluir(id);
        return resultado;

}

    @Override
    public List<Object> listar(String pfiltro) throws SQLException {
        return dao.listar(pfiltro);
    }
}

