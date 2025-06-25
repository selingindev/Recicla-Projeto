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
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));
            String nome = JOptionPane.showInputDialog("NOME");

            Municipio entMun = new Municipio(codigo, nome);
            ControllerMunicipio contCol = new ControllerMunicipio();

            Municipio saidaMun = (Municipio) contCol.inserir(entMun);
            JOptionPane.showMessageDialog(null, saidaMun.toString());
		
	}

	@Override
	public void alterar() throws SQLException, ClassNotFoundException {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("COD"));
            String nome = JOptionPane.showInputDialog("NOME");

            Municipio munEnt = new Municipio(codigo, nome);
            ControllerMunicipio contMun = new ControllerMunicipio();

            Municipio munSaida = (Municipio) contMun.alterar(munEnt);
            JOptionPane.showMessageDialog(null,munSaida.toString());
	}

	@Override
	public void excluir() throws SQLException, ClassNotFoundException {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));

            ControllerMunicipio contCol = new ControllerMunicipio();

            Boolean excluir = contCol.excluir(codigo);

            String msg = "";
            if(excluir) {
                msg = "Municipio excluido com sucesso";
            }else {
                msg = "Erro ao excluir municipio";        	
            }

            JOptionPane.showMessageDialog(null,msg);
	}

	@Override
	public void listar() throws SQLException, ClassNotFoundException {
            int cod = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));

            ControllerMunicipio contMun = new ControllerMunicipio();
            List<Object> listaMunicipio = contMun.listar("");

            for (Object colObj : listaMunicipio) {
                Municipio munSaida = (Municipio) colObj;
                JOptionPane.showMessageDialog(null,munSaida.toString());
            }
            }

        @Override
        public void buscar() throws SQLException, ClassNotFoundException {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("CÓDIGO"));

            ControllerMunicipio contMun = new ControllerMunicipio();

            Municipio munSaida = (Municipio) contMun.buscar(codigo);
            JOptionPane.showMessageDialog(null,munSaida.toString());
	}

}
