package br.com.fatec.telas.produtos;

import br.com.fatec.telas.*;
import padraomvc.model.bean.Produto;
import padraomvc.controller.ControllerProduto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class ConsultarProdutoInterface implements Initializable {

    @FXML
    private Label lbNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TableView<Produto> listaProduto;

    @FXML
    private TableColumn<Produto,String> tid;

    @FXML
    private TableColumn<Produto,String> tNome;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerProduto prodCont = null;
    
    ObservableList<Produto> oList = null;

    List<Produto> lista = null;
    
    public static Produto prodSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        prodCont = new ControllerProduto();

        btConsultar.setOnAction((ActionEvent event) -> {
            Produto prod = new Produto(txtNome.getText());
            try {
                montaLista(prod);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaProduto.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setProduto(listaProduto.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/produtos/AlterarProdutoInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaProduto.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Produto usu = listaProduto.getItems().get(row);
            try {
                prodCont.excluir(usu);
                listaProduto.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No Excluir");

            }
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
                    Logger.getLogger(ConsultarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
    }
    
    public void montaLista(Produto prod) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = prodCont.listar(prod);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((Produto) objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tid.setCellValueFactory(new PropertyValueFactory<Produto,String>("id"));
        tNome.setCellValueFactory(new PropertyValueFactory<Produto,String>("nome"));
        listaProduto.setItems(oList);
    }
    
    

    public void setProduto(Produto prodP) {
        this.prodSaidaTela = prodP;
    }
    
    public Produto getProduto() {
        return this.prodSaidaTela;
    }
}
