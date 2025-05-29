/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPessoaJuridica;
import reciclabackend.model.bean.PessoaJuridica;
import reciclabackend.util.ViewBasico;

/**
 *
 * @author olgac
 */
public class ManterPessoaJuridica implements ViewBasico {

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
                System.out.println("Opcao invalida");
                break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idPes = Integer.parseInt(JOptionPane.showInputDialog("IDPES"));
        String cnpj = JOptionPane.showInputDialog("CNPJ");
        String inscEst = JOptionPane.showInputDialog("INSC_EST");
        PessoaJuridica pessoaEnt = new PessoaJuridica(idPes, cnpj, inscEst);
        ControllerPessoaJuridica contUsu = new ControllerPessoaJuridica();
        PessoaJuridica usuSaida = (PessoaJuridica) contUsu.inserir(pessoaEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idPes = Integer.parseInt(JOptionPane.showInputDialog("IDPES"));
        String cnpj = JOptionPane.showInputDialog("CNPJ");
        String inscEst = JOptionPane.showInputDialog("INSC_EST");

        PessoaJuridica pessoaEnt = new PessoaJuridica(id, idPes, cnpj, inscEst);
        ControllerPessoaJuridica contUsu = new ControllerPessoaJuridica();
        PessoaJuridica usuSaida = (PessoaJuridica) contUsu.alterar(pessoaEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaJuridica pessoaEnt = new PessoaJuridica(id);
        ControllerPessoaJuridica contUsu = new ControllerPessoaJuridica();
        PessoaJuridica usuSaida = (PessoaJuridica) contUsu.buscar(pessoaEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaJuridica pessoaEnt = new PessoaJuridica(id);
        ControllerPessoaJuridica contUsu = new ControllerPessoaJuridica();
        PessoaJuridica usuSaida = (PessoaJuridica) contUsu.excluir(pessoaEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String cnpj = JOptionPane.showInputDialog("CNPJ");
        PessoaJuridica pessoaEnt = new PessoaJuridica(cnpj);
        ControllerPessoaJuridica contPes = new ControllerPessoaJuridica();
        List<Object> listaUsuario = contPes.listar(pessoaEnt);
        for (Object usuObj : listaUsuario) {
            PessoaJuridica pessoaSaida = (PessoaJuridica) usuObj;
            JOptionPane.showMessageDialog(null,pessoaSaida.toString());
        }
    }
}
