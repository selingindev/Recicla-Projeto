/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import recicla.controller.ControllerSistema;
import recicla.model.bean.Sistema;
import recicla.util.ViewBasico;

/**
 *
 * @author LAB 211
 */
public class ManterSistema implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2 :
                alterar();
                break;
            case 3: 
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
        String servidor = JOptionPane.showInputDialog("SERVIDOR");
        String status = JOptionPane.showInputDialog("STATUS");
        String ip = JOptionPane.showInputDialog("IP");
        Sistema sisEnt = new Sistema(nome, servidor, status, ip);
        ControllerSistema contSist = new ControllerSistema();
        Sistema sisSaida = (Sistema) contSist.inserir(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String servidor = JOptionPane.showInputDialog("SERVIDOR");
        String status = JOptionPane.showInputDialog("STATUS");
        String ip = JOptionPane.showInputDialog("IP");
        Sistema sisEnt = new Sistema(id,nome, servidor, status, ip);
        ControllerSistema contSist = new ControllerSistema();
        Sistema sisSaida = (Sistema) contSist.alterar(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Sistema sisEnt = new Sistema(id);
        ControllerSistema contSist = new ControllerSistema();
        Sistema sisSaida = (Sistema) contSist.buscar(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Sistema sisEnt = new Sistema(id);
        ControllerSistema contSist = new ControllerSistema();
        Sistema sisSaida = (Sistema) contSist.excluir(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Sistema sisEnt = new Sistema(nome);
        ControllerSistema contSist = new ControllerSistema();
        List<Object> listaUsuario = contSist.listar(sisEnt);
        for (Object Obj : listaUsuario) {
            Sistema sistema = (Sistema) Obj;
            JOptionPane.showMessageDialog(null,sistema.toString());
        }
    }
    
}
