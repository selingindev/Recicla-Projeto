package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerSistema;
import reciclabackend.model.bean.Sistema;
import reciclabackend.util.ViewBasico;

public class ManterSistema implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar";
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
                JOptionPane.showMessageDialog(null, "Opção inválida");
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

        JOptionPane.showMessageDialog(null, sisSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String servidor = JOptionPane.showInputDialog("SERVIDOR");
        String status = JOptionPane.showInputDialog("STATUS");
        String ip = JOptionPane.showInputDialog("IP");

        Sistema sisEnt = new Sistema(id, nome, servidor, status, ip);
        ControllerSistema contSist = new ControllerSistema();
        Sistema sisSaida = (Sistema) contSist.alterar(sisEnt);

        JOptionPane.showMessageDialog(null, sisSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerSistema contSist = new ControllerSistema();
        Sistema sisSaida = (Sistema) contSist.buscar(id);

        if (sisSaida != null) {
            JOptionPane.showMessageDialog(null, sisSaida.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Sistema não encontrado.");
        }
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerSistema contSist = new ControllerSistema();
        boolean sucesso = contSist.excluir(id);

        String msg = sucesso ? "Excluído com sucesso." : "Erro ao excluir.";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Filtro pelo nome (deixe vazio para todos):");
        if (filtro == null) {
            filtro = "";
        }

        ControllerSistema contSist = new ControllerSistema();
        List<Object> lista = contSist.listar(filtro);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object obj : lista) {
                Sistema sis = (Sistema) obj;
                sb.append(sis.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
