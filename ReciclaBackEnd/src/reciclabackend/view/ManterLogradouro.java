package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerLogradouro;
import reciclabackend.model.bean.Logradouro;
import reciclabackend.util.ViewBasico;

public class ManterLogradouro implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar \n 6 - Informações CEP";
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
                buscarCep();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String cep = JOptionPane.showInputDialog(null, "CEP");
        String numero = JOptionPane.showInputDialog(null, "NÚMERO");
        String complemento_outros = JOptionPane.showInputDialog(null, "COMPLEMENTO DO IMÓVEL");

        Logradouro logEntrada = new Logradouro(cep, numero, "", complemento_outros);
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        Logradouro logSaida = (Logradouro) controllerLogradouro.inserir(logEntrada);

        JOptionPane.showMessageDialog(null, logSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID"));
        String cep = JOptionPane.showInputDialog(null, "CEP");
        String numero = JOptionPane.showInputDialog(null, "NÚMERO");
        String complemento_outros = JOptionPane.showInputDialog(null, "COMPLEMENTO DO IMÓVEL");

        Logradouro logEntrada = new Logradouro(id, cep, numero, "", complemento_outros);
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        Logradouro logSaida = (Logradouro) controllerLogradouro.alterar(logEntrada);

        JOptionPane.showMessageDialog(null, logSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID"));
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        boolean sucesso = controllerLogradouro.excluir(id); // Recebe boolean

        String msg = sucesso ? "Excluído com sucesso." : "Erro ao excluir.";
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int cepInt = 0;
        String cep = JOptionPane.showInputDialog("CEP (somente números ou com hífen):");
        if (cep != null) {
            String cepNumeros = cep.replaceAll("[^0-9]", ""); // remove tudo que não é número
            cepInt = Integer.parseInt(cepNumeros);
            // agora cepInt tem só os dígitos do CEP, sem hífen
            ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
            String dadosCep = (String) controllerLogradouro.buscar(cepInt); // Busca pelo cep (String)
            JOptionPane.showMessageDialog(null, dadosCep != null ? dadosCep : "CEP não encontrado");
        }

    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String filtro = JOptionPane.showInputDialog(null, "Filtro para CEP (deixe vazio para todos):");
        if (filtro == null)
            filtro = "";

        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        List<Object> listaLogradouro = controllerLogradouro.listar(filtro); // filtro é String

        if (listaLogradouro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object logradouroItem : listaLogradouro) {
                Logradouro logradouro = (Logradouro) logradouroItem;
                sb.append(logradouro.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void buscarCep() throws ClassNotFoundException, SQLException {
        String cep = JOptionPane.showInputDialog("CEP");
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        String json = controllerLogradouro.buscarCep(cep);
        JOptionPane.showMessageDialog(null, json);

        Object[] options = { "Criar", "Cancelar" };
        int option = JOptionPane.showOptionDialog(null,
                "Deseja criar um novo logradouro com esse CEP?",
                "Informação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (option == 0) {
            controllerLogradouro.customInserir(json);
        }
        menu();
    }
}
