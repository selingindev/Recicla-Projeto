package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerPontoColeta;
import reciclabackend.model.bean.PontoColeta;
import reciclabackend.util.ViewBasico;

public class ManterPontoColeta implements ViewBasico {

    ControllerPontoColeta controller = new ControllerPontoColeta();

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        int opcao;
        do {
            String msg = "0 - Sair\n"
                       + "1 - Inserir Ponto de Coleta\n"
                       + "2 - Alterar Ponto de Coleta\n"
                       + "3 - Excluir Ponto de Coleta\n"
                       + "4 - Buscar Ponto de Coleta\n"
                       + "5 - Listar Pontos de Coleta";
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite uma opção válida numérica!");
                opcao = -1;
            }
            switch (opcao) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando...");
                    break;
                case 1:
                    inserir();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    buscar();
                    break;
                case 5:
                    listar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID:"));
            int idLog = Integer.parseInt(JOptionPane.showInputDialog("Digite o IDLOG:"));
            String nome = JOptionPane.showInputDialog("Digite o Nome:");
            String qrCode = JOptionPane.showInputDialog("Registre o QrCode:");

            PontoColeta pc = new PontoColeta(id, idLog, nome, qrCode);
            controller.inserir(pc);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido! Digite um número inteiro.");
        }
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        try {
            int alteraId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Ponto de Coleta que deseja alterar:"));

            PontoColeta pc = (PontoColeta) controller.buscar(new PontoColeta(alteraId, 0, "", ""));
            if (pc != null) {
                String novoNome = JOptionPane.showInputDialog("Digite o novo Nome:");
                pc.setNome(novoNome);
                controller.alterar(pc);
                JOptionPane.showMessageDialog(null, "Ponto de Coleta alterado com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ponto de Coleta não encontrado!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido! Digite um número inteiro.");
        }
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        try {
            int excluiId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Ponto de Coleta que deseja excluir:"));
            PontoColeta pc = new PontoColeta(excluiId, 0, "", "");
            PontoColeta excluido = (PontoColeta) controller.excluir(pc);
            if (excluido != null) {
                JOptionPane.showMessageDialog(null, "Ponto de Coleta excluído com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ponto de Coleta não encontrado!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido! Digite um número inteiro.");
        }
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        try {
            int buscaId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Ponto de Coleta que deseja buscar:"));
            PontoColeta pc = (PontoColeta) controller.buscar(new PontoColeta(buscaId, 0, "", ""));
            if (pc != null) {
                JOptionPane.showMessageDialog(null, "Ponto de Coleta encontrado:\nID: " + pc.getId() +
                                                      "\nIDLOG: " + pc.getIdLog() +
                                                      "\nNome: " + pc.getNome() +
                                                      "\nQRCode: " + pc.getQrCode(),
                                                      "Busca", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ponto de Coleta não encontrado!", "Busca", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido! Digite um número inteiro.");
        }
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        List<Object> lista = controller.listar(null);
        StringBuilder sb = new StringBuilder("Pontos de Coleta Cadastrados:\n");
        for (Object obj : lista) {
            PontoColeta pc = (PontoColeta) obj;
            sb.append("ID: ").append(pc.getId())
              .append(", IDLOG: ").append(pc.getIdLog())
              .append(", Nome: ").append(pc.getNome())
              .append(", QRCode: ").append(pc.getQrCode())
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Pontos de Coleta", JOptionPane.INFORMATION_MESSAGE);
    }
}