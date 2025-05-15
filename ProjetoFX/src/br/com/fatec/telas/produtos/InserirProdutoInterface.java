package br.com.fatec.telas.produtos;

import br.com.fatec.telas.*;
import padraomvc.model.bean.Produto;
import padraomvc.controller.ControllerProduto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Bruno Pequeno
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class InserirProdutoInterface implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btSalvar;

    @FXML
    private Label lbNome;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btVoltar;

    ControllerProduto prodCont = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }    
    
    private void initComponentes () {
        btSalvar.setOnAction((ActionEvent event) -> {
            prodCont = new ControllerProduto();
            Produto prod = new Produto(txtNome.getText());
            try {
                prod = (Produto) prodCont.inserir(prod);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, prod.getNome());
        });
        
        
        btVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }  
}
