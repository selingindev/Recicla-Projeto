/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reciclabackend;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import reciclabackend.view.ManterColPdc;
import reciclabackend.view.ManterColaborador;
import reciclabackend.view.ManterLogradouro;
import reciclabackend.view.ManterMaterial;
import reciclabackend.view.ManterPDRCOL;
import reciclabackend.view.ManterPEF_PDC;
import reciclabackend.view.ManterPessoa;
import reciclabackend.view.ManterPessoaFisica;
import reciclabackend.view.ManterPessoaJuridica;
import reciclabackend.view.ManterPontoColeta;
import reciclabackend.view.ManterPontoReciclagem;
import reciclabackend.view.ManterSistema;
import reciclabackend.view.ManterUsuario;
import reciclabackend.view.ManterUsuarioSistema;

/**
 *
 * @author LAB 211
 *         FATEC / Modelagem de Padrão de Projetos | Prof. A. Bittencourt
 */
public class Start {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario Inválido");
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n"
                + "1 - Usuario \n "
                + "2 - Sistema \n "
                + "3 - UsuarioSistema \n "
                + "4 - Material \n "
                + "5 - Logradouro \n "
                + "6 - Pessoa \n "
                + "7 - Colaborador \n"
                + "8 - Ponto de Coleta \n "
                + "9 - Ponto de reciclagem\n"
                + "10 - Pessoa Fisica\n"
                + "11 - PDR-COL\n"
                + "12 - PEF-PDC\n"
                + "13 - COL-PDC\n"
                + "14 - Pessoa Jurídica\n";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
                if (sair > 0)
                    menu();
                break;
            case 1:
                ManterUsuario mu = new ManterUsuario();
                mu.menu();
                break;
            case 2:
                ManterSistema ms = new ManterSistema();
                ms.menu();
                break;
            case 3:
                ManterUsuarioSistema mus = new ManterUsuarioSistema();
                mus.menu();
                break;
            case 4:
                ManterMaterial mat = new ManterMaterial();
                mat.menu();
                break;
            case 5:
                ManterLogradouro ml = new ManterLogradouro();
                ml.menu();
                break;
            case 6:
                ManterPessoa mp = new ManterPessoa();
                mp.menu();
                break;
            case 7:
                ManterColaborador mc = new ManterColaborador();
                mc.menu();
                break;
            case 8:
                ManterPontoColeta mpc = new ManterPontoColeta();
                mpc.menu();
                break;
            case 9:
                ManterPontoReciclagem mpr = new ManterPontoReciclagem();
                mpr.menu();
                break;
            case 10:
                ManterPessoaFisica mpf = new ManterPessoaFisica();
                mpf.menu();
                break;
            case 11:
                ManterPDRCOL mpdrcol = new ManterPDRCOL();
                mpdrcol.menu();
                break;
            case 12:
                ManterPEF_PDC mpp = new ManterPEF_PDC();
                mpp.menu();
                break;
            case 13:
                ManterColPdc mcp = new ManterColPdc();
                mcp.menu();
                break;
            case 14:
                ManterPessoaJuridica mpj = new ManterPessoaJuridica();
                mpj.menu();
                break;
            default:
                System.out.println("Opção inválido");
                break;
        }
    }

}
