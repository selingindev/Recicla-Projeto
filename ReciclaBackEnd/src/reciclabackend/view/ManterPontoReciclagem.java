/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPontoReciclagem;
import reciclabackend.model.bean.PontoReciclagem;
import reciclabackend.util.ViewBasico;

/**
 *
 * @author LAB 211
 */
public class ManterPontoReciclagem implements ViewBasico {

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
        int idPEJ = Integer.parseInt(JOptionPane.showInputDialog("idPEJ"));
        String nome = JOptionPane.showInputDialog("NOME");
        PontoReciclagem idEnt = new PontoReciclagem(idPEJ,nome);
        ControllerPontoReciclagem contId = new ControllerPontoReciclagem();
        PontoReciclagem idSaida = (PontoReciclagem) contId.inserir(idEnt);
        JOptionPane.showMessageDialog(null,idSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idPEJ = Integer.parseInt(JOptionPane.showInputDialog("idPEJ"));
        String nome = JOptionPane.showInputDialog("NOME");
        PontoReciclagem idEnt = new PontoReciclagem(id,idPEJ,nome);
        ControllerPontoReciclagem contId = new ControllerPontoReciclagem();
        PontoReciclagem idSaida = (PontoReciclagem) contId.alterar(idEnt);
        JOptionPane.showMessageDialog(null,idSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PontoReciclagem idEnt = new PontoReciclagem(id);
        ControllerPontoReciclagem contId = new ControllerPontoReciclagem();
        PontoReciclagem idSaida = (PontoReciclagem) contId.buscar(idEnt);
        JOptionPane.showMessageDialog(null,idSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PontoReciclagem idEnt = new PontoReciclagem(id);
        ControllerPontoReciclagem contId = new ControllerPontoReciclagem();
        PontoReciclagem idSaida = (PontoReciclagem) contId.excluir(idEnt);
        JOptionPane.showMessageDialog(null,idSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        int idPEJ = Integer.parseInt(JOptionPane.showInputDialog("idPEJ"));
        PontoReciclagem idEnt = new PontoReciclagem(idPEJ);


        ControllerPontoReciclagem contId = new ControllerPontoReciclagem();
        List<Object> listaUsuario = contId.listar(idEnt);
        System.out.println(listaUsuario);
        for (Object usuObj : listaUsuario) {
            System.out.println(usuObj.toString());
            PontoReciclagem usuSaida = (PontoReciclagem) usuObj;
            JOptionPane.showMessageDialog(null,usuSaida.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        int idPEJ = Integer.parseInt(JOptionPane.showInputDialog("idPEJ"));
        String nome = JOptionPane.showInputDialog("NOME");
        PontoReciclagem idEnt = new PontoReciclagem(idPEJ,nome);
        ControllerPontoReciclagem contId = new ControllerPontoReciclagem();
        return contId.validar(idEnt);
    }

    
}
