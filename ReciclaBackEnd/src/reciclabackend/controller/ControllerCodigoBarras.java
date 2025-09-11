package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.bean.CodigoBarras;
import reciclabackend.model.dao.DaoCodigoBarra;
import reciclabackend.util.CodigoBarraApiBasico;
import reciclabackend.util.ControllerBasico;
import reciclabackend.util.api.CosmoApi;
import org.json.JSONObject;

public class ControllerCodigoBarras implements ControllerBasico {

    DaoCodigoBarra dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoCodigoBarra();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoCodigoBarra();
        return dao.inserir(obj);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoCodigoBarra();
        return dao.excluir(id);
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        dao = new DaoCodigoBarra();
        return dao.buscar(id);
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException, ClassNotFoundException {
        dao = new DaoCodigoBarra();
        return dao.listar(pfiltro);
    }

    public CodigoBarras requestApi(String gtin) {
        CodigoBarraApiBasico api = new CosmoApi();

        String data = api.gtinData(gtin);

        JSONObject json = new JSONObject(data);

        String gtinConstrutor = json.getString("gtin");
        String brandName = json.getString("brand");
        String description = json.getString("description");

        CodigoBarras codigoBarras = new CodigoBarras(description, gtinConstrutor, brandName);

        return codigoBarras;

    }

}
