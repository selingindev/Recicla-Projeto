package reciclabackend.view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPEF_PDC;
import reciclabackend.model.bean.PefPdc;
import reciclabackend.util.ViewBasico;

public class ManterPEF_PDC implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar por código\n0 - Sair";
        while (true) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(msg));
            if (op == 0) return;
            switch (op) {
                case 1: inserir(); break;
                case 2: alterar(); break;
                case 3: buscar(); break;
                case 4: excluir(); break;
                case 5: listar(); break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        PefPdc p = coletar(false);
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        JOptionPane.showMessageDialog(null, "Inserido: " + c.inserir(p));
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        PefPdc p = coletar(true);
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        JOptionPane.showMessageDialog(null, "Alterado: " + c.alterar(p));
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID a excluir"));
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        if (c.excluir(id)) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir.");
        }
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        PefPdc p = (PefPdc) c.buscar(id);
        JOptionPane.showMessageDialog(null, p == null ? "Não encontrado" : p.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Buscar por código (ou parte):");
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        List<Object> list = c.listar(filtro);
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem registros");
        } else {
            StringBuilder sb = new StringBuilder();
            list.forEach(o -> sb.append(o).append("\n"));
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private PefPdc coletar(boolean pedirId) {
        int id = pedirId ? Integer.parseInt(JOptionPane.showInputDialog("ID")) : 0;
        int idPef = Integer.parseInt(JOptionPane.showInputDialog("ID_PEF"));
        int idCol = Integer.parseInt(JOptionPane.showInputDialog("ID_COL"));
        int idMat = Integer.parseInt(JOptionPane.showInputDialog("ID_MAT"));
        int idPdc = Integer.parseInt(JOptionPane.showInputDialog("ID_PDC"));
        String cod = JOptionPane.showInputDialog("COD");
        double quant = Double.parseDouble(JOptionPane.showInputDialog("QUANT"));
        String dataStr = JOptionPane.showInputDialog("DATA (yyyy-MM-dd)");
        Date data = Date.valueOf(dataStr);
        return new PefPdc(id, idPef, idCol, idMat, idPdc, cod, quant, data);
    }
}
