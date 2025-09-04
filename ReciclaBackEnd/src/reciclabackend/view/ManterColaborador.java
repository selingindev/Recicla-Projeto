package reciclabackend.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import reciclabackend.controller.ControllerColaborador;
import reciclabackend.model.bean.Colaborador;
import reciclabackend.util.ViewBasico;

public class ManterColaborador implements ViewBasico {

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
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
            int funcional = Integer.parseInt(JOptionPane.showInputDialog("FUNCIONAL"));

            Colaborador entCol = new Colaborador(id, funcional);
            ControllerColaborador contCol = new ControllerColaborador();

            Colaborador saidaCol = (Colaborador) contCol.inserir(entCol);
            JOptionPane.showMessageDialog(null, saidaCol.toString());
		
	}

	@Override
	public void alterar() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
            int funcional = Integer.parseInt(JOptionPane.showInputDialog("FUNCIONAL"));

            Colaborador colEnt = new Colaborador(id,funcional);
            ControllerColaborador contCol = new ControllerColaborador();

            Colaborador colSaida = (Colaborador) contCol.alterar(colEnt);
            JOptionPane.showMessageDialog(null,colSaida.toString());
	}

	@Override
	public void excluir() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		
            ControllerColaborador contCol = new ControllerColaborador();

            Boolean excluir = contCol.excluir(id);

            String msg = "";
            if(excluir) {
                msg = "Colaborador excluido com sucesso";
            }else {
                msg = "Erro ao excluir colaborador";        	
            }
        
            JOptionPane.showMessageDialog(null,msg);
	}

	@Override
	public void listar() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
            Colaborador colEnt = new Colaborador(id);

            ControllerColaborador contCol = new ControllerColaborador();
            List<Object> listaColaborador = contCol.listar(""); // Erro

            for (Object colObj : listaColaborador) {
                Colaborador colSaida = (Colaborador) colObj;
                JOptionPane.showMessageDialog(null,colSaida.toString());
            }
	}

	@Override
	public void buscar() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));

            ControllerColaborador contCol = new ControllerColaborador();

            Colaborador colaida = (Colaborador) contCol.buscar(id);
            JOptionPane.showMessageDialog(null,colaida.toString());
	}

}
