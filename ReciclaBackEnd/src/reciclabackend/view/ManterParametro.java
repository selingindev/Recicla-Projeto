package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerParametro;
import reciclabackend.model.bean.Parametro;
import reciclabackend.util.ViewBasico;

public class ManterParametro implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar\n0 - Sair";
        while (true) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(msg));
            if (opc == 0) return;
            switch (opc) {
                case 1 : inserir();break;
                case 2 : alterar();break;
                case 3 : buscar();break;
                case 4 : excluir();break;
                case 5 : listar(); break; 
                default : JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));
        String descricao = JOptionPane.showInputDialog("DESCRIÇÃO");

        Parametro parEntrada = new Parametro(cod, descricao);
        ControllerParametro controller = new ControllerParametro();
        Parametro parSaida = (Parametro) controller.inserir(parEntrada);

        JOptionPane.showMessageDialog(null, parSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));
        String descricao = JOptionPane.showInputDialog("DESCRIÇÃO");

        Parametro parEntrada = new Parametro(cod, descricao);
        ControllerParametro controller = new ControllerParametro();
        Parametro parSaida = (Parametro) controller.alterar(parEntrada);

        JOptionPane.showMessageDialog(null, parSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));

        ControllerParametro controller = new ControllerParametro();
        boolean sucesso = controller.excluir(cod);

        JOptionPane.showMessageDialog(null, sucesso ? "Excluído com sucesso!" : "Erro ao excluir.");
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int cod = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));

        ControllerParametro controller = new ControllerParametro();
        Parametro parSaida = (Parametro) controller.buscar(cod);

        JOptionPane.showMessageDialog(null,
                parSaida != null ? parSaida.toString() : "Parâmetro não encontrado.");
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Digite parte da descrição para filtrar (deixe vazio para todos):");
        if (filtro == null) filtro = "";

        ControllerParametro controller = new ControllerParametro();
        List<Object> listaParametro = controller.listar(filtro.trim());

        if (listaParametro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum parâmetro encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listaParametro) {
                Parametro parametro = (Parametro) obj;
                sb.append(parametro.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
