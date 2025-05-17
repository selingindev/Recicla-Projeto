package br.com.fatec.telas.colaborador;

import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import recicla.controller.ControllerColaborador;
import recicla.model.bean.Colaborador;
import utils.NavigationUtil;

public class AlterarColaboradorInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recicla.AlterarColaboradorInterface.fxml"));
        
       System.out.println(root);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @FXML private TextField searchField;
    @FXML public TextField novoFuncional;
    @FXML private Button btnSearch;
    @FXML private Button btnConfirmar;
    
    @FXML
    private void handleSearch(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int id = Integer.parseInt(searchField.getText());
        Colaborador colEnt = new Colaborador(id);
		
        // Pesquisa Colaborador
        ControllerColaborador contCol = new ControllerColaborador();
        List<Object> listaColaborador = contCol.listar(colEnt);
        
        for (Object colObj : listaColaborador) {
            Colaborador colSaida = (Colaborador) colObj;
            novoFuncional.setText(String.valueOf(colSaida.getFuncional()));
        }
    }
    
    @FXML
    private void handleAlter(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int id = Integer.parseInt(novoFuncional.getText());
        Colaborador colEnt = new Colaborador(id);
        ControllerColaborador contCol = new ControllerColaborador();
        
        Colaborador colSaida = (Colaborador) contCol.alterar(colEnt);
        JOptionPane.showMessageDialog(null,colSaida.toString());
    }
    
          @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}