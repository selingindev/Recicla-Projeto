
package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPDRCOL;
import reciclabackend.model.bean.PdrCol;
import reciclabackend.util.ViewBasico;


public class ManterPDRCOL implements ViewBasico {

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
        PdrCol p = coletar(false);
        ControllerPDRCOL c = new ControllerPDRCOL();
        JOptionPane.showMessageDialog(null, "Inserido: " + c.inserir(p));
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        PdrCol p = coletar(true);
        ControllerPDRCOL c = new ControllerPDRCOL();
        JOptionPane.showMessageDialog(null, "Alterado: " + c.alterar(p));
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID a excluir"));
        ControllerPDRCOL c = new ControllerPDRCOL();
        if (c.excluir(id)) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir.");
        }
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerPDRCOL c = new ControllerPDRCOL();
        PdrCol p = (PdrCol) c.buscar(id);
        JOptionPane.showMessageDialog(null, p == null ? "Não encontrado" : p.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Buscar por código (ou parte):");
        ControllerPDRCOL c = new ControllerPDRCOL();
        List<Object> list = c.listar(filtro);
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem registros");
        } else {
            StringBuilder sb = new StringBuilder();
            list.forEach(o -> sb.append(o).append("\n"));
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private PdrCol coletar(boolean pedirId) {
        int id = pedirId ? Integer.parseInt(JOptionPane.showInputDialog("ID")) : 0;
        int idPRD = Integer.parseInt(JOptionPane.showInputDialog("IDPRD"));
        int idCOL = Integer.parseInt(JOptionPane.showInputDialog("IDCOL"));
        return new PdrCol(id, idPRD, idCOL);
    }


}