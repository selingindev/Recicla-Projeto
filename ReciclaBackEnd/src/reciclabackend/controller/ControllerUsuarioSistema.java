package reciclabackend.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reciclabackend.model.bean.Sistema;
import reciclabackend.model.bean.Usuario;
import reciclabackend.model.bean.UsuarioSistema;
import reciclabackend.model.dao.DaoUsuarioSistema;
import reciclabackend.util.ControllerBasico;

public class ControllerUsuarioSistema implements ControllerBasico {

    private DaoUsuarioSistema dao;
    private ControllerUsuario contUsu;
    private ControllerSistema contSis;

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
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();
        return dao.excluir(id);
    }

    @Override
    public UsuarioSistema buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();

        // busca o vínculo
        UsuarioSistema usuSis = (UsuarioSistema) dao.buscar(id);
        if (usuSis == null) {
            return null;
        }

        // carrega usuário e sistema relacionados
        contUsu = new ControllerUsuario();
        contSis = new ControllerSistema();

        Usuario u = (Usuario) contUsu.buscar(usuSis.getIdU());
        Sistema s = (Sistema) contSis.buscar(usuSis.getIdS());

        usuSis.setUsu(u);
        usuSis.setSis(s);
        return usuSis;
    }

    @Override
    public List<Object> listar(String filtro) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioSistema();
        List<Object> raw = dao.listar(filtro);
        List<Object> enriched = new ArrayList<>();

        for (Object o : raw) {
            UsuarioSistema us = (UsuarioSistema) o;
            // reutiliza buscar para preencher usuário e sistema
            enriched.add(this.buscar(us.getId()));
        }
        return enriched;
    }
}
