package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerUsuario;
import reciclabackend.model.bean.Usuario;
import reciclabackend.util.ViewBasico;

public class ManterUsuario implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1: inserir(); break;
            case 2: alterar(); break;
            case 3: buscar(); break;
            case 4: excluir(); break;
            case 5: listar(); break;
            default: System.out.println("Opção inválida"); break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");

        Usuario usuEnt = new Usuario(login, senha, status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");

        Usuario usuEnt = new Usuario(id, login, senha, status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.buscar(id);

        if (usuSaida != null) {
            JOptionPane.showMessageDialog(null, usuSaida.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
        }
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ControllerUsuario contUsu = new ControllerUsuario();
        boolean sucesso = contUsu.excluir(id);

        String msg = sucesso ? "Usuário excluído com sucesso!" : "Usuário não encontrado para exclusão.";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Filtro de LOGIN:");
        ControllerUsuario contUsu = new ControllerUsuario();
        List<Object> listaUsuario = contUsu.listar(filtro);

        for (Object usuObj : listaUsuario) {
            Usuario usuSaida = (Usuario) usuObj;
            JOptionPane.showMessageDialog(null, usuSaida.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        Usuario usuEnt = new Usuario(login, senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        return contUsu.validar(usuEnt);
    }
}
