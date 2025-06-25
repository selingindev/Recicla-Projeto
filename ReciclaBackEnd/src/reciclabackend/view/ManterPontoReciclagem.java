package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPontoReciclagem;
import reciclabackend.model.bean.PontoReciclagem;
import reciclabackend.util.ViewBasico;

public class ManterPontoReciclagem implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar";
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));
        
        switch (opcao) {
            case 1: inserir(); break;
            case 2: alterar(); break;
            case 3: buscar(); break;
            case 4: excluir(); break;
            case 5: listar(); break;
            default: JOptionPane.showMessageDialog(null, "Opção inválida."); break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idPEJ = Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa Jurídica:"));
        String nome = JOptionPane.showInputDialog("Nome do Ponto de Reciclagem:");
        
        PontoReciclagem ponto = new PontoReciclagem(idPEJ, nome);
        ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
        PontoReciclagem result = (PontoReciclagem) controller.inserir(ponto);
        
        JOptionPane.showMessageDialog(null, result.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        int idPEJ = Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa Jurídica:"));
        String nome = JOptionPane.showInputDialog("Novo nome do Ponto de Reciclagem:");
        
        PontoReciclagem ponto = new PontoReciclagem(id, idPEJ, nome);
        ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
        PontoReciclagem result = (PontoReciclagem) controller.alterar(ponto);
        
        JOptionPane.showMessageDialog(null, result.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        
        ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
        PontoReciclagem result = (PontoReciclagem) controller.buscar(id);
        
        JOptionPane.showMessageDialog(null, result.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        
        ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
        boolean result =  controller.excluir(id);
        
        JOptionPane.showMessageDialog(null, "Excluído: " + result);
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Filtrar por ID da Pessoa Jurídica (deixe em branco para todos):");
        ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
        List<Object> lista = controller.listar(filtro);
        
        for (Object obj : lista) {
            PontoReciclagem ponto = (PontoReciclagem) obj;
            JOptionPane.showMessageDialog(null, ponto.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        int idPEJ = Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa Jurídica:"));
        String nome = JOptionPane.showInputDialog("Nome:");
        
        PontoReciclagem ponto = new PontoReciclagem(idPEJ, nome);
        ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
        
        return controller.validar(ponto);
    }
}
