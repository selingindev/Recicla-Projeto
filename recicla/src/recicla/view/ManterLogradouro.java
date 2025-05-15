package recicla.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import recicla.controller.ControllerLogradouro;
import recicla.model.bean.Logradouro;

import recicla.util.ViewBasico;

public class ManterLogradouro implements ViewBasico {

    @Override
    public  void menu() throws SQLException, ClassNotFoundException {
     String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar \n 6- Informações CEP";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2 :
                alterar();
                break;
            case 3: 
                buscar();
                break;
            case 4 :
                excluir();
                break;
            case 5 :
                listar();
                break;
            case 6 :
                buscarCep();
                break;    
            default :
                System.out.println("Opcao inválida");
                break;
        }
    }

    @Override
    public  void inserir() throws SQLException, ClassNotFoundException {
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

        Logradouro logEntrada = new Logradouro(id);
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        Logradouro logSaida = (Logradouro) controllerLogradouro.excluir(logEntrada);

        JOptionPane.showMessageDialog(null, logSaida.toString());
        
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        String cep = JOptionPane.showInputDialog("CEP");
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        Logradouro logEntrada = new Logradouro(cep);
        String dadosCep = (String) controllerLogradouro.buscar(logEntrada);
        JOptionPane.showMessageDialog(null, dadosCep);
        
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String cep = JOptionPane.showInputDialog(null, "CEP");
        
        Logradouro logEntrada = new Logradouro(cep);
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        List<Object> listaLogradouro = controllerLogradouro.listar(logEntrada);
        for(Object logradouroItem : listaLogradouro){
            Logradouro logradouro = (Logradouro) logradouroItem;
            JOptionPane.showMessageDialog(null, logradouro.toString());
        }
    }

    public void buscarCep() throws ClassNotFoundException, SQLException{
        
        String cep = JOptionPane.showInputDialog("CEP");
        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
        String json = controllerLogradouro.buscarCep(cep);
        JOptionPane.showMessageDialog(null, json);


        Object[] options = { "Criar", "Cancelar" };
       int option =  JOptionPane.showOptionDialog(null, "Deseja criar um novo logradouro com esse CEP?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (option == 0) {
            controllerLogradouro.customInserir(json);
        }
        menu();
    }


    
}
