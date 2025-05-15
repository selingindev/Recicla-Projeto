package recicla.view;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import recicla.controller.ControllerColPdc;
import recicla.model.bean.ColPdc;
import recicla.util.ViewBasico;

public class ManterColPdc implements ViewBasico{

    static ControllerColPdc controller = new ControllerColPdc();

    

     @Override
    public  void menu() throws SQLException, ClassNotFoundException {
     String msg = " 1 - Inserir \n "
             + "2 - Alterar \n "
             + "3 - buscar \n "
             + "4 - excluir \n "
             + "5 - Listar ";
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
            default :
                System.out.println("Opcao inválida");
                break;
        }
    }

    @Override
    public  void inserir() throws SQLException, ClassNotFoundException {
        int id_COL = Integer.parseInt(JOptionPane.showInputDialog(null, "ID COLABORADOR: ")); 
        int id_PDC = Integer.parseInt(JOptionPane.showInputDialog(null, "ID PONTO DE COLETA: "));
        LocalDate dataLocal = LocalDate.now();
        
        try {
           ColPdc colpdcEnt = new ColPdc(0, id_COL, id_PDC, dataLocal);
           ColPdc saidaColPdc = (ColPdc) controller.inserir(colpdcEnt);
           JOptionPane.showMessageDialog(null, saidaColPdc.toString());
        } catch (HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID"));
        int id_COL = Integer.parseInt(JOptionPane.showInputDialog(null, "NOVO ID COLABORADOR: ")); 
        int id_PDC = Integer.parseInt(JOptionPane.showInputDialog(null, "NOVO ID PONTO DE COLETA: "));
        LocalDate novaData = LocalDate.now();
        
        
        try {
           ColPdc colpdcEnt = new ColPdc(id, id_COL, id_PDC, novaData );
           ColPdc saidaColPdc = (ColPdc) controller.alterar(colpdcEnt);
           JOptionPane.showMessageDialog(null, saidaColPdc.toString());
        } catch ( HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID - COL-PDC"));

        ColPdc colpdcEnt = new ColPdc(id);
        ColPdc colpdcSaida = (ColPdc) controller.excluir(colpdcEnt);

        JOptionPane.showMessageDialog(null, colpdcSaida.toString() + "  deletado com sucesso");
        
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ColPdc logEntrada = new ColPdc(id);
        ColPdc colPdc = (ColPdc) controller.buscar(logEntrada);
        JOptionPane.showMessageDialog(null, colPdc);
        
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID"));
        
        ColPdc logEntrada = new ColPdc(id);
        List<Object> listaLogradouro = controller.listar(logEntrada);
        for(Object colpdcItem : listaLogradouro){
            ColPdc colpdc = (ColPdc) colpdcItem;
            JOptionPane.showMessageDialog(null, colpdc.toString());
        }
    }
}
