package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;
import reciclabackend.model.bean.Usuario;
import reciclabackend.model.dao.DaoUsuario;
import reciclabackend.util.ControllerBasico;

public class ControllerUsuario implements ControllerBasico {

    private DaoUsuario dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.alterar(obj);
    }

    // Buscar por ID
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.buscar(id);
    }

    // Excluir por ID
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.excluir(id);
    }

    // Listar com filtro String
    public List<Object> listar(String filtro) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.listar(filtro);
    }

    // Método para validar usuário (login e senha)
    public boolean validar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        Usuario usuSaida = dao.validar(usuEnt);
        return usuSaida != null;
    }

    // Variante que retorna o usuário completo para uso em Web ou outras finalidades
    public Usuario validarWeb(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuario();
        return dao.validar(usuEnt);
    }
}
