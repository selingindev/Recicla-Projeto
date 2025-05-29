/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas.municipio;

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
import recicla.controller.ControllerMunicipio;
import recicla.model.bean.Municipio;
import utils.NavigationUtil;

/**
 *
 * @author raife
 */
public class AlterarMunicipioInterface extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recicla.AlterarMunicipioInterface.fxml"));
        
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
        
        int codigo = Integer.parseInt(TextCodigoPesquisa.getText());
        Municipio munEnt = new Municipio(codigo);
		
        // Pesquisa Colaborador
        ControllerMunicipio contPar = new ControllerMunicipio();
        List<Object> listaMunicipios = contPar.listar(munEnt);
        
        if(!listaMunicipios.isEmpty()){
            Municipio municipioEncontrado = (Municipio) listaMunicipios.get(0);
            
            TextCodigo.setText(String.valueOf(municipioEncontrado.getCodigo()));
            TextDescricao.setText(municipioEncontrado.getNome());
        }else{
            System.out.println("Nenhum municipio encontrado");
        }
    }
    
    @FXML
    private void handleAlter(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        int cod = Integer.parseInt(TextCodigo.getText());
        String descricao = TextDescricao.getText();
        Municipio munEnt = new Municipio(cod, descricao);
        
        ControllerMunicipio controllerMunicipio = new ControllerMunicipio();
        Municipio munSaida = (Municipio) controllerMunicipio.alterar(munEnt);

        JOptionPane.showMessageDialog(null, munSaida.toString());
    }
    
    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
