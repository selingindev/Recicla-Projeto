/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import recicla.controller.ControllerPDRCOL;
import recicla.model.bean.PDRCOL;
import recicla.util.ViewBasico;

/**
 *
 * @author LAB 211
 */
public class ManterPDRCOL implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = "1 - Inserir \n2 - Alterar \n3 - Buscar \n4 - Excluir \n5 - Listar";
        while (true) {
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        if (num == 0) {
            JOptionPane.showMessageDialog(null, "Encerrando o menu...");
            return; // ou break; se quiser sair apenas do while
        }

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
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                break;
        }
    }}

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idPRD = Integer.parseInt(JOptionPane.showInputDialog("IDPRD:"));
        int idCOL = Integer.parseInt(JOptionPane.showInputDialog("IDCOL:"));

        PDRCOL pdrEnt = new PDRCOL(0, idPRD, idCOL); // ID é 0 porque será gerado no banco de dados
        ControllerPDRCOL contPdr = new ControllerPDRCOL();
        PDRCOL pdrSaida = (PDRCOL) contPdr.inserir(pdrEnt);

        JOptionPane.showMessageDialog(null, "Inserido com sucesso:\n" + pdrSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        int idPRD = Integer.parseInt(JOptionPane.showInputDialog("IDPRD:"));
        int idCOL = Integer.parseInt(JOptionPane.showInputDialog("IDCOL:"));

        PDRCOL pdrEnt = new PDRCOL(id, idPRD, idCOL);
        ControllerPDRCOL contPdr = new ControllerPDRCOL();
        PDRCOL pdrSaida = (PDRCOL) contPdr.alterar(pdrEnt);

        JOptionPane.showMessageDialog(null, "Alterado com sucesso:\n" + pdrSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        PDRCOL pdrEnt = new PDRCOL(id);
        ControllerPDRCOL contPdr = new ControllerPDRCOL();
        PDRCOL pdrSaida = (PDRCOL) contPdr.buscar(pdrEnt);

        if (pdrSaida != null) {
            JOptionPane.showMessageDialog(null, "Resultado da busca:\n" + pdrSaida.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
        }
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        PDRCOL pdrEnt = new PDRCOL(id);
        ControllerPDRCOL contPdr = new ControllerPDRCOL();
        PDRCOL pdrSaida = (PDRCOL) contPdr.excluir(pdrEnt);

        if (pdrSaida != null) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso:\n" + pdrSaida.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir. Registro não encontrado.");
        }
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        ControllerPDRCOL contPdr = new ControllerPDRCOL();
        List<Object> listaPDR = contPdr.listar(null); // Lista todos os registros

        if (listaPDR.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
            return;
        }

        StringBuilder resultado = new StringBuilder("Lista de Registros PDRCOL:\n");
        for (Object obj : listaPDR) {
            PDRCOL pdrSaida = (PDRCOL) obj;
            resultado.append(pdrSaida.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }


}