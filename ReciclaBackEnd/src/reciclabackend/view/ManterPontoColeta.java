package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPontoColeta;
import reciclabackend.model.bean.PontoColeta;
import reciclabackend.util.ViewBasico;

public class ManterPontoColeta implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n"
                   + "2 - Alterar\n"
                   + "3 - Buscar\n"
                   + "4 - Excluir\n"
                   + "5 - Listar";
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (opcao) {
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
                JOptionPane.showMessageDialog(null, "Opção inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("IDLOG"));
        String nome = JOptionPane.showInputDialog("Nome");
        String qrCode = JOptionPane.showInputDialog("QRCode");

        PontoColeta pc = new PontoColeta(id, idLog, nome, qrCode);
        ControllerPontoColeta controller = new ControllerPontoColeta();
        PontoColeta retorno = (PontoColeta) controller.inserir(pc);
        JOptionPane.showMessageDialog(null, retorno.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("IDLOG"));
        String nome = JOptionPane.showInputDialog("Nome");
        String qrCode = JOptionPane.showInputDialog("QRCode");

        PontoColeta pc = new PontoColeta(id, idLog, nome, qrCode);
        ControllerPontoColeta controller = new ControllerPontoColeta();
        PontoColeta retorno = (PontoColeta) controller.alterar(pc);
        JOptionPane.showMessageDialog(null, retorno.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerPontoColeta controller = new ControllerPontoColeta();
        boolean sucesso = controller.excluir(id);
        String msg = sucesso ? "Ponto de Coleta excluído com sucesso" : "Erro ao excluir";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerPontoColeta controller = new ControllerPontoColeta();
        PontoColeta pc = (PontoColeta) controller.buscar(id);
        JOptionPane.showMessageDialog(null, pc != null ? pc.toString() : "Ponto de Coleta não encontrado");
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Filtro de nome (deixe em branco para todos):");
        ControllerPontoColeta controller = new ControllerPontoColeta();
        List<Object> lista = controller.listar(filtro);
        StringBuilder sb = new StringBuilder("Pontos de Coleta:\n");
        for (Object obj : lista) {
            PontoColeta pc = (PontoColeta) obj;
            sb.append(pc.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
