package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import reciclabackend.controller.ControllerMaterial;
import reciclabackend.model.bean.Material;
import reciclabackend.util.ViewBasico;

public class ManterMaterial implements ViewBasico {
#####
    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
                break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        String descricao = JOptionPane.showInputDialog("DESCRIÇÃO");
        Material materialEnt = new Material(nome, descricao);
        ControllerMaterial matController = new ControllerMaterial();
        Material materialSaida = (Material) matController.inserir(materialEnt);
        JOptionPane.showMessageDialog(null, materialSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String descricao = JOptionPane.showInputDialog("DESCRIÇÃO");
        Material materialEnt = new Material(id, nome, descricao);
        ControllerMaterial matController = new ControllerMaterial();
        Material materialSaida = (Material) matController.alterar(materialEnt);
        JOptionPane.showMessageDialog(null, materialSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Material materialEnt = new Material(id);
        ControllerMaterial matController = new ControllerMaterial();
        Material materialSaida = (Material) matController.excluir(materialEnt);
        JOptionPane.showMessageDialog(null, materialSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Material materialEnt = new Material(id);
        ControllerMaterial matController = new ControllerMaterial();
        Material materialSaida = (Material) matController.buscar(materialEnt);
        JOptionPane.showMessageDialog(null, materialSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Material materialEnt = new Material(nome);
        ControllerMaterial matController = new ControllerMaterial();
        List<Object> listaMaterial = matController.listar(materialEnt);
        for (Object matObj : listaMaterial) {
            Material materialSaida = (Material) matObj;
            JOptionPane.showMessageDialog(null, materialSaida.toString());
        }
    }
}
