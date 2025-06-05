package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import reciclabackend.model.bean.CodigoBarras;
import reciclabackend.util.CodigoBarraApiBasico;
import reciclabackend.util.ControllerBasico;
import reciclabackend.util.api.CosmoApi;


public class ControllerCodigoBarras implements ControllerBasico {

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public Object buscar(int id) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<Object> listar(String pfiltro) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    public CodigoBarras requestApi(String gtin){
      CodigoBarraApiBasico api = new CosmoApi();   
        
    String json = api.gtinData(gtin);
     JSONObject json = new JSONObject(resposta.toString());
    
    String gtin = 
    CodigoBarras codigoBarras = new CodigoBarras(, 0, json)
        
      return


    }

}
