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
    public Object inserir(Object obj) throws SQLException {
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        return dao.excluir(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        return dao.buscar(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException {
        return dao.listar(obj);
    }
}
