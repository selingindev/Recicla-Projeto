package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerMunicipio;
import reciclabackend.model.bean.Municipio;
import reciclabackend.util.ViewBasico;

public class ManterMunicipio implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar\n0 - Sair";
        while (true) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(msg));
            if (opc == 0) return;
            switch (opc) {
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
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));
        String nome = JOptionPane.showInputDialog("NOME");

        Municipio entMun = new Municipio(codigo, nome);
        ControllerMunicipio contMun = new ControllerMunicipio();

        Municipio saidaMun = (Municipio) contMun.inserir(entMun);
        JOptionPane.showMessageDialog(null, saidaMun.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));
        String nome = JOptionPane.showInputDialog("NOME");

        Municipio munEnt = new Municipio(codigo, nome);
        ControllerMunicipio contMun = new ControllerMunicipio();

        Municipio munSaida = (Municipio) contMun.alterar(munEnt);
        JOptionPane.showMessageDialog(null, munSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));

        ControllerMunicipio contMun = new ControllerMunicipio();
        boolean sucesso = contMun.excluir(codigo);

        String msg = sucesso ? "Município excluído com sucesso" : "Erro ao excluir município";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Digite parte do nome para filtrar (deixe vazio para todos):");
        if (filtro == null) filtro = "";

        ControllerMunicipio contMun = new ControllerMunicipio();
        List<Object> listaMunicipio = contMun.listar(filtro.trim());

        if (listaMunicipio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum município encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listaMunicipio) {
                Municipio mun = (Municipio) obj;
                sb.append(mun.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));

        ControllerMunicipio contMun = new ControllerMunicipio();
        Municipio munSaida = (Municipio) contMun.buscar(codigo);

        JOptionPane.showMessageDialog(null,
                munSaida != null ? munSaida.toString() : "Município não encontrado.");
    }
}
