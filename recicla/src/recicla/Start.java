/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recicla;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import recicla.view.ManterColPdc;
import recicla.view.ManterColaborador;
import recicla.view.ManterLogradouro;
import recicla.view.ManterMaterial;
import recicla.view.ManterPDRCOL;
import recicla.view.ManterPEF_PDC;
import recicla.view.ManterPessoa;
import recicla.view.ManterPessoaFisica;
import recicla.view.ManterPessoaJuridica;
import recicla.view.ManterPontoColeta;
import recicla.view.ManterPontoReciclagem;
import recicla.view.ManterSistema;
import recicla.view.ManterUsuario;
import recicla.view.ManterUsuarioSistema;

/**
 *
 * @author LAB 211
 */
public class Start {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n"
                + " 1 - Usuario \n "
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
            case 0 : 
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1 : 
                ManterUsuario mu = new ManterUsuario();
                mu.menu();
                break;
            case 2 : 
                ManterSistema ms = new ManterSistema();
                ms.menu();
                break;
            case 3 : 
                ManterUsuarioSistema mus = new ManterUsuarioSistema();
                mus.menu();
                break;
            case 4 : 
                ManterMaterial mat = new ManterMaterial();
                mat.menu();
                break;
            case 5 :
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
            default : 
                System.out.println("Opção inválido");
                break;
        }
    }
    
}
