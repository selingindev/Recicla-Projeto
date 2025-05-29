/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

/**
 *
 * @author Cateli
 */




import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.dao.DaoPessoaFisica;
import reciclabackend.util.ControllerBasico;

public class ControllerPessoaFisica implements ControllerBasico {

    DaoPessoaFisica dao = new DaoPessoaFisica();

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaFisica();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaFisica();
        return dao.alterar(obj);
    }

    @Override
    public boolean excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaFisica();
        return dao.excluir(id);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaFisica();
        return dao.buscar(id);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoaFisica();
        return dao.listar(pfiltro);
    }
}
