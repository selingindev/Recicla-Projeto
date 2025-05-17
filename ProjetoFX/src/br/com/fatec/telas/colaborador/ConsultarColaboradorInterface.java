package br.com.fatec.telas.colaborador;

import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import recicla.controller.ControllerColaborador;
import recicla.model.bean.Colaborador;
import utils.NavigationUtil;

public class ConsultarColaboradorInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recicla.ConsultarColaboradorInterface.fxml"));
        
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
    @FXML private Button btnSearch;
    @FXML private TableView tableColaborador;
    
    @FXML
    private void handleSearch(ActionEvent event) throws SQLException, ClassNotFoundException {
        System.out.println("You clicked me!");
        
        int id = Integer.parseInt(searchField.getText());
        Colaborador colEnt = new Colaborador(id);
		
        // Pesquisa Colaborador
        ControllerColaborador contCol = new ControllerColaborador();
        List<Object> listaColaborador = contCol.listar(colEnt);
        
        // Adicionando os dados na tabela
        tableColaborador.setItems((ObservableList) listaColaborador);
    }
          @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}