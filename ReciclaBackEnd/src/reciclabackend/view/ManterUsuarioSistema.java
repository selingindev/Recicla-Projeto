package reciclabackend.view;

import reciclabackend.controller.ControllerUsuarioSistema;
import reciclabackend.model.bean.UsuarioSistema;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.util.ViewBasico;

public class ManterUsuarioSistema implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar";
        int opc = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (opc) {
            case 1 -> inserir();
            case 2 -> alterar();
            case 3 -> buscar();
            case 4 -> excluir();
            case 5 -> listar();
            default -> JOptionPane.showMessageDialog(null, "Opção inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuário"));
        int idSistema = Integer.parseInt(JOptionPane.showInputDialog("ID do Sistema"));
        String obs = JOptionPane.showInputDialog("Observações");

        UsuarioSistema usuSis = new UsuarioSistema(idUsuario, idSistema, obs);
        ControllerUsuarioSistema controller = new ControllerUsuarioSistema();
        UsuarioSistema resultado = (UsuarioSistema) controller.inserir(usuSis);

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do vínculo"));
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuário"));
        int idSistema = Integer.parseInt(JOptionPane.showInputDialog("ID do Sistema"));
        String obs = JOptionPane.showInputDialog("Observações");

        UsuarioSistema usuSis = new UsuarioSistema(id, idUsuario, idSistema, obs);
        ControllerUsuarioSistema controller = new ControllerUsuarioSistema();
        UsuarioSistema resultado = (UsuarioSistema) controller.alterar(usuSis);

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do vínculo"));
        ControllerUsuarioSistema controller = new ControllerUsuarioSistema();
        UsuarioSistema resultado = controller.buscar(id);

        if (resultado != null) {
            JOptionPane.showMessageDialog(null, resultado.toString());
            JOptionPane.showMessageDialog(null, resultado.getUsu().toString());
            JOptionPane.showMessageDialog(null, resultado.getSis().toString());
        } else {
            JOptionPane.showMessageDialog(null, "Vínculo não encontrado");
        }
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do vínculo"));
        ControllerUsuarioSistema controller = new ControllerUsuarioSistema();
        boolean sucesso = controller.excluir(id);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Vínculo excluído com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir vínculo.");
        }
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Filtro de Observações (ou deixe vazio)");
        ControllerUsuarioSistema controller = new ControllerUsuarioSistema();
        List<Object> lista = controller.listar(filtro);

        for (Object obj : lista) {
            UsuarioSistema us = (UsuarioSistema) obj;
            JOptionPane.showMessageDialog(null, us.toString());
            JOptionPane.showMessageDialog(null, us.getUsu().toString());
            JOptionPane.showMessageDialog(null, us.getSis().toString());
        }
    }
}
