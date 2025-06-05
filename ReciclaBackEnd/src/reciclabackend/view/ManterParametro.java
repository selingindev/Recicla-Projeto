/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import reciclabackend.controller.ControllerParametro;
import reciclabackend.model.bean.Parametro;

import reciclabackend.util.ViewBasico;

public class ManterParametro implements ViewBasico {
    @Override
    public  void menu() throws SQLException, ClassNotFoundException {
     String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar";
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
    public  void inserir() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "CÓDIGO")); 
        String descricao = JOptionPane.showInputDialog(null, "DESCRICÃO");
        
        Parametro parEntrada = new Parametro(cod, descricao);
        ControllerParametro controllerParametro = new ControllerParametro();
        Parametro parSaida = (Parametro) controllerParametro.inserir(parEntrada);

        JOptionPane.showMessageDialog(null, parSaida.toString());
            
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "CÓDIGO"));
        String descricao = JOptionPane.showInputDialog(null, "DESCRICAO"); 
        
        Parametro parEntrada = new Parametro(cod, descricao);
        ControllerParametro controllerParametro = new ControllerParametro();
        Parametro parSaida = (Parametro) controllerParametro.alterar(parEntrada);

        JOptionPane.showMessageDialog(null, parSaida.toString());
    }
    
    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "CÓDIGO"));

        ControllerParametro controllerParametro = new ControllerParametro();
        Boolean parSaida = controllerParametro.excluir(cod);

        JOptionPane.showMessageDialog(null, parSaida.toString());
        
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "CÓDIGO"));
        String descricao = JOptionPane.showInputDialog(null, "DESCRICAO");
        
        ControllerParametro controllerParametro = new ControllerParametro();
        String dadosPar = (String) controllerParametro.buscar(cod);
        JOptionPane.showMessageDialog(null, dadosPar);
        
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "CÓDIGO"));
        String descricao = JOptionPane.showInputDialog(null, "DESCRICAO");
        
        ControllerParametro controllerParametro = new ControllerParametro();
        List<Object> listaParametro = controllerParametro.listar(descricao);
        for(Object ParametroItem : listaParametro){
            Parametro parametro = (Parametro) ParametroItem;
            JOptionPane.showMessageDialog(null, parametro.toString());
        }
    }
    
}
