package recicla.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import recicla.controller.ControllerPEF_PDC;
import recicla.model.bean.PEF_PDC;
import recicla.util.ViewBasico;

public class ManterPEF_PDC implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar por PEF";
        while (true){
        int op = Integer.parseInt(JOptionPane.showInputDialog(msg));
        if(op == 0) return;
        switch (op) {
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
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        PEF_PDC p = coletar(false);
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        JOptionPane.showMessageDialog(null, "Inserido: " + c.inserir(p));
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        PEF_PDC p = coletar(true);
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        JOptionPane.showMessageDialog(null, "Alterado: " + c.alterar(p));
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID a excluir"));
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        c.excluir(new PEF_PDC(id,0,0,0,0,0,0,null));
        JOptionPane.showMessageDialog(null, "Excluído!");
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        PEF_PDC p = (PEF_PDC) c.buscar(new PEF_PDC(id,0,0,0,0,0,0,null));
        JOptionPane.showMessageDialog(null, p==null? "Não encontrado" : p.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        int idPef = Integer.parseInt(JOptionPane.showInputDialog("ID_PEF"));
        ControllerPEF_PDC c = new ControllerPEF_PDC();
        List<Object> list = c.listar(new PEF_PDC(0,idPef,0,0,0,0,0,null));
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem registros");
        } else {
            StringBuilder sb = new StringBuilder();
            list.forEach(o -> sb.append(o).append("\n"));
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private PEF_PDC coletar(boolean pedirId) {
        int id = pedirId ? Integer.parseInt(JOptionPane.showInputDialog("ID")) : 0;
        int idPef = Integer.parseInt(JOptionPane.showInputDialog("ID_PEF"));
        int idCol = Integer.parseInt(JOptionPane.showInputDialog("ID_COL"));
        int idMat = Integer.parseInt(JOptionPane.showInputDialog("ID_MAT"));
        int idPdc = Integer.parseInt(JOptionPane.showInputDialog("ID_PDC"));
        int cod = Integer.parseInt(JOptionPane.showInputDialog("COD"));
        int quant = Integer.parseInt(JOptionPane.showInputDialog("QUANT"));
        String data = JOptionPane.showInputDialog("DATA (yyyy-MM-dd)");
        return new PEF_PDC(id, idPef, idCol, idMat, idPdc, cod, quant, data);
    }
}