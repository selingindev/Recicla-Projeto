package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import reciclabackend.controller.ControllerValorGame;
import reciclabackend.model.bean.ValorGame;
import reciclabackend.util.ViewBasico;

public class ManterValorGame implements ViewBasico {

	@Override
	public void menu() throws SQLException, ClassNotFoundException {
            String msg = " 1 - Inserir \n "
                                 + "2 - Alterar \n "
                                 + "3 - buscar \n "
                                 + "4 - excluir \n "
                                 + "5 - Listar " ;

            int num = Integer.parseInt(JOptionPane.showInputDialog(msg));

            switch(num) {
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
                default : 
                    System.out.println("Opção inválida");
                    break;
            }
	}

	@Override
	public void inserir() throws SQLException, ClassNotFoundException {
            int mat = Integer.parseInt(JOptionPane.showInputDialog("Material"));
            int par = Integer.parseInt(JOptionPane.showInputDialog("Parametro"));
            int muni = Integer.parseInt(JOptionPane.showInputDialog("Municipio"));
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
            int nivel = Integer.parseInt(JOptionPane.showInputDialog("Nível"));

            ValorGame entValor = new ValorGame(valor, nivel, mat, par, muni);
            ControllerValorGame contValor = new ControllerValorGame();

            ValorGame saidaValor = (ValorGame) contValor.inserir(entValor);
            JOptionPane.showMessageDialog(null, saidaValor.toString());
		
	}

	@Override
	public void alterar() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
            
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
            int nivel = Integer.parseInt(JOptionPane.showInputDialog("Nível"));
            int mat = Integer.parseInt(JOptionPane.showInputDialog("Material"));
            int par = Integer.parseInt(JOptionPane.showInputDialog("Parametro"));
            int muni = Integer.parseInt(JOptionPane.showInputDialog("Municipio"));

            ValorGame valorEnt = new ValorGame(id, valor, nivel, mat, par, muni);
            ControllerValorGame contValor = new ControllerValorGame();

            ValorGame valorSaida = (ValorGame) contValor.alterar(valorEnt);
            JOptionPane.showMessageDialog(null,valorSaida.toString());
	}

	@Override
	public void excluir() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		
            ControllerValorGame contValor = new ControllerValorGame();

            Boolean excluir = contValor.excluir(id);

            String msg = "";
            if(excluir) {
                msg = "Valor excluido com sucesso";
            }else {
                msg = "Erro ao excluir valor";        	
            }
        
            JOptionPane.showMessageDialog(null,msg);
	}

	@Override
	public void listar() throws SQLException, ClassNotFoundException {
            String nivel = JOptionPane.showInputDialog("Nível");

            ControllerValorGame contValor = new ControllerValorGame();
            List<Object> listaValores = contValor.listar(nivel);
            
            for (Object valorObj : listaValores) {
                ValorGame valorSaida = (ValorGame) valorObj;
                JOptionPane.showMessageDialog(null,valorSaida.toString());
            }
	}

	@Override
	public void buscar() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));

            ControllerValorGame contValor = new ControllerValorGame();

            ValorGame valorSaida = (ValorGame) contValor.buscar(id);
            JOptionPane.showMessageDialog(null,valorSaida.toString());
	}

}
