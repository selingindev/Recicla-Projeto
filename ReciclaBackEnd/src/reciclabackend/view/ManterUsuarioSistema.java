/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.view;

import reciclabackend.controller.ControllerUsuarioSistema;
import reciclabackend.model.bean.UsuarioSistema;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.util.ViewBasico;

/**
 *
 * @author User
 */
public class ManterUsuarioSistema implements ViewBasico{
    
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
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idS = Integer.parseInt(JOptionPane.showInputDialog("IDS"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioSistema usuEnt = new UsuarioSistema(idU, idS, obs);
        ControllerUsuarioSistema contUsu = new ControllerUsuarioSistema();
        UsuarioSistema usuSaida = (UsuarioSistema) contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idS = Integer.parseInt(JOptionPane.showInputDialog("IDS"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioSistema usuEnt = new UsuarioSistema(id,idU, idS, obs);
        ControllerUsuarioSistema contUsu = new ControllerUsuarioSistema();
        UsuarioSistema usuSaida = (UsuarioSistema) contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioSistema usuEnt = new UsuarioSistema(id);
        ControllerUsuarioSistema contUsu = new ControllerUsuarioSistema();
        UsuarioSistema usuSaida = (UsuarioSistema) contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        JOptionPane.showMessageDialog(null,usuSaida.getUsu().toString());
        JOptionPane.showMessageDialog(null,usuSaida.getSis().toString());

    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioSistema usuEnt = new UsuarioSistema(id);
        ControllerUsuarioSistema contUsu = new ControllerUsuarioSistema();
        UsuarioSistema usuSaida = (UsuarioSistema) contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioSistema usuEnt = new UsuarioSistema(obs);
        ControllerUsuarioSistema contUsu = new ControllerUsuarioSistema();
        List<Object> listaUsuario = contUsu.listar(usuEnt);
        for (Object usuObj : listaUsuario) {
            UsuarioSistema usuSaida = (UsuarioSistema) usuObj;
            JOptionPane.showMessageDialog(null,usuSaida.toString());
            JOptionPane.showMessageDialog(null,usuSaida.getUsu().toString());
            JOptionPane.showMessageDialog(null,usuSaida.getSis().toString());
        }
    }

}
