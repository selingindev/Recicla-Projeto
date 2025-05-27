package reciclabackend.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import reciclabackend.util.api.CepApi;
import reciclabackend.model.bean.Logradouro;
import reciclabackend.model.dao.DaoLogradouro;
import reciclabackend.util.ControllerBasico;

public class ControllerLogradouro implements ControllerBasico {

    private DaoLogradouro dao;
    CepApi cepApi = new CepApi();

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLogradouro();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLogradouro();
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLogradouro();
        return dao.excluir(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLogradouro();
        return dao.buscar(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLogradouro();
        return dao.listar(obj);
    }

    public String buscarCep(String cep) {
        String infoCep = cepApi.getCep(cep).replace("{", "").trim();
        return infoCep;
    }

    public void customInserir(String json) throws ClassNotFoundException, SQLException {

        String[] dadosSplit = json.split(",");

        String cepJson = dadosSplit[0];
        String complementoJson = dadosSplit[2];
        String[] complementoSplit = complementoJson.split(":");
        String[] cepSplit = cepJson.split(":");


        String cep = cepSplit[1].replace("-", "").replaceAll("\"", "").trim();
        String complemento_api = complementoSplit[1].trim();
        String numero = JOptionPane.showInputDialog(null, "NÚMERO");
        String complemento_outros = JOptionPane.showInputDialog(null, "COMPLEMENTO DO IMÓVEL");

        Logradouro logEntrada = new Logradouro(cep, numero, complemento_api, complemento_outros);

        Logradouro logSaida = (Logradouro) inserir(logEntrada);

         JOptionPane.showMessageDialog(null, logSaida.toString());
    }

}
