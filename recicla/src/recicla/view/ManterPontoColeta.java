/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import recicla.controller.ControllerPontoColeta;
import recicla.model.bean.PontoColeta;
import recicla.util.ViewBasico;

public class ManterPontoColeta implements ViewBasico {

    ControllerPontoColeta controller = new ControllerPontoColeta();

    public static void main(String[] args) {
        try {
            new ManterPontoColeta().menu();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

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
            opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));
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
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID:"));
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("Digite o IDLOG:"));
        String nome = JOptionPane.showInputDialog("Digite o Nome:");
        
        PontoColeta pc = new PontoColeta(id, idLog, nome);
        PontoColeta pcSaida = (PontoColeta) controller.inserir(pc);
        JOptionPane.showMessageDialog(null,pcSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int alteraId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Ponto de Coleta que deseja alterar:"));
        
        PontoColeta pc = (PontoColeta) controller.buscar(new PontoColeta(alteraId));
        if (pc != null) {
            String novoNome = JOptionPane.showInputDialog("Digite o novo Nome:");
            pc.setNome(novoNome);
            PontoColeta pcSaida = (PontoColeta) controller.alterar(pc);
            JOptionPane.showMessageDialog(null, "Ponto de Coleta alterado com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,pcSaida.toString());

        } else {
            JOptionPane.showMessageDialog(null, "Ponto de Coleta não encontrado!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int excluiId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Ponto de Coleta que deseja excluir:"));
        PontoColeta pc = new PontoColeta(excluiId);
        PontoColeta excluido = (PontoColeta) controller.excluir(pc);
        if (excluido != null) {
            JOptionPane.showMessageDialog(null, "Ponto de Coleta excluído com sucesso!", excluido.toString(), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ponto de Coleta não encontrado!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int buscaId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Ponto de Coleta que deseja buscar:"));
        PontoColeta pc = (PontoColeta) controller.buscar(new PontoColeta(buscaId));
        if (pc != null) {
            JOptionPane.showMessageDialog(null, "Ponto de Coleta encontrado:\nID: " + pc.getId() + "\nNome: " + pc.getNome(),
                                          "Busca", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ponto de Coleta não encontrado!", "Busca", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Insira o nome do ponto");
        PontoColeta pcEnt = new PontoColeta(nome);
        List<Object> lista = controller.listar(pcEnt);
        StringBuilder sb = new StringBuilder("Pontos de Coleta Cadastrados:\n");
        for (Object obj : lista) {
            PontoColeta pc = (PontoColeta) obj;
            sb.append("ID: ").append(pc.getId())
              .append(", Nome: ").append(pc.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Pontos de Coleta", JOptionPane.INFORMATION_MESSAGE);
    }
}
