package reciclabackend.view;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import reciclabackend.controller.ControllerColPdc;
import reciclabackend.model.bean.ColPdc;
import reciclabackend.util.ViewBasico;

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
        
        String data = dataLocal.toString();
        
        try {
           ColPdc colpdcEnt = new ColPdc(0, id_COL, id_PDC, data);
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
        String data = novaData.toString();
        
        try {
           ColPdc colpdcEnt = new ColPdc(id, id_COL,id_PDC,data);
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
    boolean sucesso = controller.excluir(colpdcEnt.getId());

    if (sucesso) {
        JOptionPane.showMessageDialog(null, colpdcEnt.toString() + " deletado com sucesso");
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao excluir. Registro não encontrado.");
    }
}

    @Override
public void buscar() throws SQLException, ClassNotFoundException {
    int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));

    ColPdc resultado = (ColPdc) controller.buscar(id);
    if (resultado != null) {
        JOptionPane.showMessageDialog(null, resultado.toString());
    } else {
        JOptionPane.showMessageDialog(null, "Registro não encontrado.");
    }
}

    @Override
public void listar() throws SQLException, ClassNotFoundException {
    String filtro = JOptionPane.showInputDialog(null, "Digite o ID_COL para filtrar ou deixe em branco:");

    List<Object> lista = controller.listar((filtro == null || filtro.isEmpty()) ? null : filtro);

    if (lista.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
        return;
    }

    StringBuilder resultado = new StringBuilder("Registros encontrados:\n");
    for (Object item : lista) {
        ColPdc colpdc = (ColPdc) item;
        resultado.append(colpdc.toString()).append("\n");
    }

    JOptionPane.showMessageDialog(null, resultado.toString());
}
}
