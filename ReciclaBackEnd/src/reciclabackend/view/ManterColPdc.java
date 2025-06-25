package reciclabackend.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerColPdc;
import reciclabackend.model.bean.ColPdc;
import reciclabackend.util.ViewBasico;

public class ManterColPdc implements ViewBasico {

    static ControllerColPdc controller = new ControllerColPdc();

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar\n0 - Sair";
        while (true) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(msg));
            if (op == 0) return;
            switch (op) {
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
        int idCol = Integer.parseInt(JOptionPane.showInputDialog("ID COLABORADOR:"));
        int idPdc = Integer.parseInt(JOptionPane.showInputDialog("ID PONTO DE COLETA:"));
        String data = LocalDate.now().toString();

        ColPdc entrada = new ColPdc(0, idCol, idPdc, data);
        ColPdc saida = (ColPdc) controller.inserir(entrada);
        JOptionPane.showMessageDialog(null, saida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        int idCol = Integer.parseInt(JOptionPane.showInputDialog("NOVO ID COLABORADOR:"));
        int idPdc = Integer.parseInt(JOptionPane.showInputDialog("NOVO ID PONTO DE COLETA:"));
        String data = LocalDate.now().toString();

        ColPdc entrada = new ColPdc(id, idCol, idPdc, data);
        ColPdc saida = (ColPdc) controller.alterar(entrada);
        JOptionPane.showMessageDialog(null, saida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID - COL-PDC"));
        boolean sucesso = controller.excluir(id);
        String msg = sucesso ? "Excluído com sucesso." : "Erro ao excluir.";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        ColPdc saida = (ColPdc) controller.buscar(id);
        JOptionPane.showMessageDialog(null, saida != null ? saida.toString() : "Não encontrado");
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Filtro para ID_COL (deixe vazio para todos):");
        if (filtro == null) filtro = "";
        List<Object> lista = controller.listar(filtro);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object obj : lista) {
                sb.append(obj.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
