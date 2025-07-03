package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

import reciclabackend.controller.ControllerCodigoBarras;
import reciclabackend.model.bean.CodigoBarras;
import reciclabackend.util.ViewBasico;

public class ManterCodigoBarras implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar \n 6 - Buscar na API";
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
            case 6:
                buscarApi();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }
    }

@Override
public void inserir() throws SQLException, ClassNotFoundException {
    String gtin = JOptionPane.showInputDialog(null, "Informe o GTIN para consulta na API:");
    if (gtin == null || gtin.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "GTIN inválido.");
        return;
    }

    ControllerCodigoBarras controller = new ControllerCodigoBarras();

    try {
        CodigoBarras cb = controller.requestApi(gtin.trim());

        int op = JOptionPane.showConfirmDialog(null,
                "Dados encontrados:\n" + cb.toString() + "\n\nDeseja inserir esse código no sistema?",
                "Confirmar Inserção",
                JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            CodigoBarras cbSaida = (CodigoBarras) controller.inserir(cb);
            JOptionPane.showMessageDialog(null, "Inserido com sucesso:\n" + cbSaida.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Inserção cancelada.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar API: " + e.getMessage());
    }
}

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID do Código de Barras para alterar"));
        String description = JOptionPane.showInputDialog(null, "Nova Descrição");
        String gtdin = JOptionPane.showInputDialog(null, "Novo GTIN");
        String brandName = JOptionPane.showInputDialog(null, "Nova Marca");

        CodigoBarras cbEntrada = new CodigoBarras(id, description, gtdin, brandName);
        ControllerCodigoBarras controller = new ControllerCodigoBarras();
        CodigoBarras cbSaida = (CodigoBarras) controller.alterar(cbEntrada);

        JOptionPane.showMessageDialog(null, "Alterado: " + cbSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID do Código de Barras para excluir"));
        ControllerCodigoBarras controller = new ControllerCodigoBarras();
        boolean sucesso = controller.excluir(id);

        String msg = sucesso ? "Excluído com sucesso." : "Erro ao excluir.";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID do Código de Barras para buscar"));
        ControllerCodigoBarras controller = new ControllerCodigoBarras();
        CodigoBarras cb = (CodigoBarras) controller.buscar(id);

        if (cb != null) {
            JOptionPane.showMessageDialog(null, cb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Código de Barras não encontrado.");
        }
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog(null, "Filtro para descrição (deixe vazio para todos):");
        if (filtro == null)
            filtro = "";

        ControllerCodigoBarras controller = new ControllerCodigoBarras();
        List<Object> lista = controller.listar(filtro);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object obj : lista) {
                CodigoBarras cb = (CodigoBarras) obj;
                sb.append(cb.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void buscarApi() throws SQLException, ClassNotFoundException {
        String gtin = JOptionPane.showInputDialog("Informe o GTIN para consulta na API:");
        ControllerCodigoBarras controller = new ControllerCodigoBarras();

        try {
            CodigoBarras cb = controller.requestApi(gtin);
            JOptionPane.showMessageDialog(null, "Dados da API:\n" + cb.toString());

            int op = JOptionPane.showConfirmDialog(null, "Deseja inserir esse código no sistema?");
            if (op == JOptionPane.YES_OPTION) {
                controller.inserir(cb);
                JOptionPane.showMessageDialog(null, "Código inserido com sucesso.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar API: " + e.getMessage());
        }
    }

}
