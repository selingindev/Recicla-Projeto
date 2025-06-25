package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerMaterial;
import reciclabackend.model.bean.Material;
import reciclabackend.util.ViewBasico;

public class ManterMaterial implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar\n0 - Sair";
        while (true) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(msg));
            if (opc == 0) return;
            switch (opc) {
                case 1 -> inserir();
                case 2 -> alterar();
                case 3 -> buscar();
                case 4 -> excluir();
                case 5 -> listar();
                default -> JOptionPane.showMessageDialog(null, "Opção inválida");
            }
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
        ControllerMaterial matController = new ControllerMaterial();
        boolean sucesso = matController.excluir(id);
        String msg = sucesso ? "Material excluído com sucesso." : "Erro ao excluir material.";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerMaterial matController = new ControllerMaterial();
        Material materialSaida = (Material) matController.buscar(id);
        JOptionPane.showMessageDialog(null, 
            materialSaida != null ? materialSaida.toString() : "Material não encontrado.");
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Digite parte do nome para filtrar (deixe vazio para todos):");
        ControllerMaterial matController = new ControllerMaterial();
        List<Object> listaMaterial = matController.listar(filtro == null ? "" : filtro.trim());
        if (listaMaterial.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum material encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listaMaterial) {
                sb.append(obj.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
