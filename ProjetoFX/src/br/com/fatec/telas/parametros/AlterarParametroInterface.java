/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas.parametros;

import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
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
public class AlterarParametroInterface extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recicla.AlterarParametroInterface.fxml"));
        
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
    
    @FXML private TextField TextCodigoPesquisa;
    @FXML private Button btnSearch;
    @FXML private TextField TextCodigo;
    @FXML private TextField TextDescricao;
    @FXML private Button btnSave;
    
    @FXML
    private void handleSearch(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int id = Integer.parseInt(TextCodigoPesquisa.getText());
        String descricao = TextDescricao.getText();
        Parametro parEnt = new Parametro(id);
		
        // Pesquisa Colaborador
        ControllerParametro contPar = new ControllerParametro();
        List<Object> listaParametros = contPar.listar(parEnt);
        
        if(!listaParametros.isEmpty()){
            Parametro parametroEncontrado = (Parametro) listaParametros.get(0);
            
            TextCodigo.setText(String.valueOf(parametroEncontrado.getCod()));
            TextDescricao.setText(parametroEncontrado.getDescricao());
        }else{
            System.out.println("Nenhum parâmetro encontrado");
        }
    }
    
    @FXML
    private void handleAlter(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int cod = Integer.parseInt(TextCodigo.getText());
        String descricao = TextDescricao.getText();
        Parametro parEnt = new Parametro(cod, descricao);
        
        ControllerParametro controllerParametro = new ControllerParametro();
        Parametro parSaida = (Parametro) controllerParametro.alterar(parEnt);

        JOptionPane.showMessageDialog(null, parSaida.toString());
    }
    
    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
