/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.view;

/**
 *
 * @author Cateli
 */




import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import recicla.controller.ControllerPessoaFisica;
import recicla.model.bean.PessoaFisica;
import recicla.util.ViewBasico;

public class ManterPessoaFisica implements ViewBasico{


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
        String cpf = JOptionPane.showInputDialog("CPF");
        String rg = JOptionPane.showInputDialog("RG");
        PessoaFisica pessoaEnt = new PessoaFisica(idPes, cpf, rg);
        ControllerPessoaFisica contPef = new ControllerPessoaFisica();
        PessoaFisica pefSaida = (PessoaFisica) contPef.inserir(pessoaEnt);
        JOptionPane.showMessageDialog(null,pefSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idPes = Integer.parseInt(JOptionPane.showInputDialog("IDPES"));
        String cpf = JOptionPane.showInputDialog("CPF");
        String rg = JOptionPane.showInputDialog("RG");

        PessoaFisica pessoaEnt = new PessoaFisica(id, idPes, cpf, rg);
        ControllerPessoaFisica contPef = new ControllerPessoaFisica();
        PessoaFisica pefSaida = (PessoaFisica) contPef.alterar(pessoaEnt);
        JOptionPane.showMessageDialog(null,pefSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaFisica pessoaEnt = new PessoaFisica(id);
        ControllerPessoaFisica contPef = new ControllerPessoaFisica();
        PessoaFisica pefSaida = (PessoaFisica) contPef.buscar(pessoaEnt);
        JOptionPane.showMessageDialog(null,pefSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaFisica pessoaEnt = new PessoaFisica(id);
        ControllerPessoaFisica contPef = new ControllerPessoaFisica();
        PessoaFisica pefSaida = (PessoaFisica) contPef.excluir(pessoaEnt);
        JOptionPane.showMessageDialog(null,pefSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String cpf = JOptionPane.showInputDialog("CPF");
        PessoaFisica pessoaEnt = new PessoaFisica(cpf);
        ControllerPessoaFisica contPes = new ControllerPessoaFisica();
        List<Object> listaUsuario = contPes.listar(pessoaEnt);
        for (Object usuObj : listaUsuario) {
            PessoaFisica pessoaSaida = (PessoaFisica) usuObj;
            JOptionPane.showMessageDialog(null,pessoaSaida.toString());
        }
    }
}
