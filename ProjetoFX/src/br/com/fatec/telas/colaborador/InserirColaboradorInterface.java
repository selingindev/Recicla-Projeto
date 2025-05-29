package br.com.fatec.telas.colaborador;

import java.sql.SQLException;
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

public class InserirColaboradorInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recicla.InserirColaboradorInterface.fxml"));
        
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
    
    @FXML private TextField TextFuncional;
    @FXML private Button btnInsert;
    
    @FXML
    private void handleInsert(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int funcional = Integer.parseInt(TextFuncional.getText());
        
        Colaborador entCol = new Colaborador(funcional);
        ControllerColaborador contCol = new ControllerColaborador();

        Colaborador saidaCol = (Colaborador) contCol.inserir(entCol);
        JOptionPane.showMessageDialog(null, saidaCol.toString());
    }
    
    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}