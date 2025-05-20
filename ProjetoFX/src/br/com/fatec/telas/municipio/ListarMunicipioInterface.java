/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas.municipio;

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
import recicla.controller.ControllerMunicipio;
import recicla.model.bean.Municipio;
import utils.NavigationUtil;

/**
 *
 * @author raife
 */
public class ListarMunicipioInterface extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recicla.ListarMunicipioInterface.fxml"));
        
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
    @FXML private Button btnSearch;
    @FXML private TableView tableColaborador;
    
    @FXML
    private void handleSearch(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int codigo = Integer.parseInt(TextCodigo.getText());
        String nome = TextDescricao.getText();
        Municipio munEnt = new Municipio(codigo);
		
        // Pesquisa Colaborador
        ControllerMunicipio contMun = new ControllerMunicipio();
        List<Object> listaMunicipio = contMun.listar(munEnt);
        
        // Adicionando os dados na tabela
        tableColaborador.setItems((ObservableList) listaMunicipio);
    }
    
    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
