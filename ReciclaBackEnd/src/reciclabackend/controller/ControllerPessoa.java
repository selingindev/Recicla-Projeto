/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.controller;

/**
 *
 * @author olgac
 */
import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.bean.Logradouro;
import reciclabackend.model.bean.Pessoa;

import reciclabackend.model.dao.DaoPessoa;
import reciclabackend.util.ControllerBasico;

public class ControllerPessoa implements ControllerBasico{
    DaoPessoa dao;
    ControllerLogradouro contLog;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        ControllerLogradouro controller = new ControllerLogradouro();
        Pessoa pessoa = (Pessoa) dao.buscar(id);
        Logradouro log = (Logradouro) controller.buscar(pessoa.getIdLog());
        pessoa.setLog(log);
        return pessoa;
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        return dao.excluir(id);
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        contLog = new ControllerLogradouro();
        
        List<Object> pessoas = dao.listar(filtro);
        for (Object p: pessoas){
            Pessoa pes = (Pessoa) p;
            int idLog = pes.getIdLog();
            Logradouro log = (Logradouro) contLog.buscar(idLog);
            if(log == null){
                return null;
            }
            pes.setLog(log);
        }
        return pessoas;
    }
    
    public List<Object> listarTodos()  throws SQLException, ClassNotFoundException {
        dao = new DaoPessoa();
        dao = new DaoPessoa();
        contLog = new ControllerLogradouro();
        
        List<Object> pessoas = dao.listarTodos();
        for (Object p: pessoas){
            Pessoa pes = (Pessoa) p;
            int idLog = pes.getIdLog();
            Logradouro log = (Logradouro) contLog.buscar(idLog);
            if(log == null){
                return null;
            }
            pes.setLog(log);
        }
        return pessoas;
    }
}

