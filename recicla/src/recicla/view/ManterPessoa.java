/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.view;

/**
 *
 * @author olgac
 */
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import recicla.controller.ControllerPessoa;
import recicla.model.bean.Pessoa;
import recicla.util.ViewBasico;

public class ManterPessoa implements ViewBasico{

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 : 
                inserir();
                break;
            case 2 : 
                alterar();
                break;
            case 3 : 
                buscar();
                break;
            case 4 : 
                excluir();
                break;
            case 5 : 
                listar();
                break;
            default : 
                System.out.println("Opcao inválida");
                break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        
        int id_LOG = Integer.parseInt(JOptionPane.showInputDialog("ID_LOG"));
        Pessoa pesEnt = new Pessoa(nome, id_LOG);
        ControllerPessoa contUsu = new ControllerPessoa();
        Pessoa pesSaida = (Pessoa) contUsu.inserir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("ID_LOG"));
        Pessoa pesEnt = new Pessoa(id, nome, idLog);
        ControllerPessoa contPes = new ControllerPessoa();
        Pessoa pesSaida = (Pessoa) contPes.alterar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pesEnt = new Pessoa(id);
        ControllerPessoa contPes = new ControllerPessoa();
        Pessoa pesSaida = (Pessoa) contPes.excluir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pesEnt = new Pessoa(id);
        ControllerPessoa contPes = new ControllerPessoa();
        Pessoa pesSaida = (Pessoa) contPes.buscar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());

    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Pessoa pesEnt = new Pessoa(nome);
        ControllerPessoa contPes = new ControllerPessoa();
        List<Object> listaUsuario = contPes.listar(pesEnt);
        for (Object pessaObject : listaUsuario) {
            Pessoa pessoaSaida = (Pessoa) pessaObject;
            JOptionPane.showMessageDialog(null,pessoaSaida.toString());
        }
    }
    
}
