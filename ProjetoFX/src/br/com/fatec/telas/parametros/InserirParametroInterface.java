/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas.parametros;

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
import recicla.controller.ControllerParametro;
import recicla.model.bean.Parametro;
import utils.NavigationUtil;

/**
 *
 * @author raife
 */
public class InserirParametroInterface extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recicla.InserirParametroInterface.fxml"));
        
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
    
    @FXML private TextField TextCodigo;
    @FXML private TextField TextDescricao;
    @FXML private Button btnInsert;
    
    @FXML
    private void handleInsert(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int codigo = Integer.parseInt(TextCodigo.getText());
        String descricao = TextDescricao.getText();
        
        Parametro entPar = new Parametro(codigo, descricao);
        ControllerParametro contPar = new ControllerParametro();

        Parametro saidaPar = (Parametro) contPar.inserir(entPar);
        JOptionPane.showMessageDialog(null, saidaPar.toString());
    }
    
    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
