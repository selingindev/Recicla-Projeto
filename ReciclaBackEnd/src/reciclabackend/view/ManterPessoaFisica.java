package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPessoaFisica;
import reciclabackend.model.bean.PessoaFisica;
import reciclabackend.util.ViewBasico;

public class ManterPessoaFisica implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir\n2 - Alterar\n3 - Buscar\n4 - Excluir\n5 - Listar";
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (opcao) {
            case 1 : inserir();     break;
            case 2 : alterar(); break;
            case 3 : buscar(); break;
            case 4 : excluir(); break;
            case 5 : listar(); break;
            default : JOptionPane.showMessageDialog(null, "Opção inválida."); break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idPes = Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa"));
        String cpf = JOptionPane.showInputDialog("CPF");
        String rg = JOptionPane.showInputDialog("RG");

        PessoaFisica pf = new PessoaFisica(idPes, cpf, rg);
        ControllerPessoaFisica controller = new ControllerPessoaFisica();
        PessoaFisica pfSaida = (PessoaFisica) controller.inserir(pf);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int idPes = Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa (idpes)"));
        String cpf = JOptionPane.showInputDialog("Novo CPF");
        String rg = JOptionPane.showInputDialog("Novo RG");

        PessoaFisica pf = new PessoaFisica(idPes, cpf, rg);
        ControllerPessoaFisica controller = new ControllerPessoaFisica();
        PessoaFisica pfSaida = (PessoaFisica) controller.alterar(pf);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int idPes = Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa (idpes) para buscar"));
        ControllerPessoaFisica controller = new ControllerPessoaFisica();
        PessoaFisica pfSaida = (PessoaFisica) controller.buscar(idPes);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int idPes = Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa (idpes) para excluir"));
        ControllerPessoaFisica controller = new ControllerPessoaFisica();
        boolean sucesso = controller.excluir(idPes);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Pessoa física excluída com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Pessoa física não encontrada.");
        }
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog("Filtrar por CPF ou RG (pressione OK para listar tudo)");
        ControllerPessoaFisica controller = new ControllerPessoaFisica();
        List<Object> lista = controller.listar(filtro);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
        } else {
            for (Object obj : lista) {
                PessoaFisica pf = (PessoaFisica) obj;
                JOptionPane.showMessageDialog(null, pf.toString());
            }
        }
    }
}
