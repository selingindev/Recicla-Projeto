package br.com.fatec.telas.relacoes;

import br.com.fatec.telas.*;
import br.com.fatec.telas.relacoes.AlterarRelacaoInterface;
import padraomvc.model.bean.UsuarioProduto;
import padraomvc.controller.ControllerUsuarioProduto;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerProduto;
import padraomvc.model.bean.Produto;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Bruno Pequeno
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class ConsultarRelacaoInterface implements Initializable {

    @FXML
    private Label lbObs;

    @FXML
    private TextField txtObs;

    @FXML
    private TableView<UsuarioProdutoAux> listaUsuarioProduto;

    @FXML
    private TableColumn<UsuarioProdutoAux,String> tId;

    @FXML
    private TableColumn<UsuarioProdutoAux,String> tIdU;
    
    @FXML
    private TableColumn<UsuarioProdutoAux,String> tLogin;
    
    @FXML
    private TableColumn<UsuarioProdutoAux,String> tNomeP;
    
    @FXML
    private TableColumn<UsuarioProdutoAux,String> tIdP;
    
    @FXML
    private TableColumn<UsuarioProdutoAux,String> tObs;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;
    
    @FXML
    private ComboBox<String> comboBoxUsuarios;

    @FXML
    private ComboBox<String> comboBoxProdutos;

    ControllerUsuarioProduto usuProdCont = null;
    
    ObservableList<UsuarioProdutoAux> oList = null;

    List<UsuarioProdutoAux> lista = null;
    
    public static UsuarioProdutoAux usuProdSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        try {
            popularComboBoxProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
    
    private void initComponentes (){

        usuProdCont = new ControllerUsuarioProduto();

        btConsultar.setOnAction((ActionEvent event) -> {
            UsuarioProduto usuProd = new UsuarioProduto(txtObs.getText());
            try {
                montaLista(usuProd);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaUsuarioProduto.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setUsuarioProduto(listaUsuarioProduto.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/relacoes/AlterarRelacaoInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuarioProduto.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            UsuarioProdutoAux usuProd = listaUsuarioProduto.getItems().get(row);
            try {
                usuProdCont.excluirId(usuProd.getId());
                listaUsuarioProduto.getItems().remove(row);
                JOptionPane.showMessageDialog(null, "Relacão deletada");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro ao Excluir");

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
                    Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
    }
    
    public void montaLista(UsuarioProduto usuProd) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = usuProdCont.listar(usuProd);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            ControllerUsuarioProduto usuProdCont = new ControllerUsuarioProduto();
            UsuarioProduto usuProdMod = (UsuarioProduto) objLista;

            String loginUsuario = (String) usuProdCont.buscarUsuario(usuProdMod.getIdU());
            String nomeProduto = (String) usuProdCont.buscarProduto(usuProdMod.getIdP());

            UsuarioProdutoAux usuarioProdutoAux = new UsuarioProdutoAux();
            usuarioProdutoAux.setId(usuProdMod.getId());
            usuarioProdutoAux.setIdU(usuProdMod.getIdU());
            usuarioProdutoAux.setIdP(usuProdMod.getIdP());
            usuarioProdutoAux.setObs(usuProdMod.getObs());
            usuarioProdutoAux.setNomeProduto(nomeProduto);
            usuarioProdutoAux.setLoginUsuario(loginUsuario);
            
            System.out.println(usuarioProdutoAux);

            lista.add(usuarioProdutoAux);
        }
        
        oList = FXCollections.observableArrayList(lista);
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tIdU.setCellValueFactory(new PropertyValueFactory<>("idU"));
        tLogin.setCellValueFactory(new PropertyValueFactory<>("loginUsuario"));
        tIdP.setCellValueFactory(new PropertyValueFactory<>("idP"));
        tNomeP.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        tObs.setCellValueFactory(new PropertyValueFactory<>("obs"));
        listaUsuarioProduto.setItems(oList);
    }
    
    private void popularComboBoxProdutos() throws SQLException, ClassNotFoundException {
    ControllerProduto prodCont = new ControllerProduto();
    List<Object> listaProdutos = prodCont.listar(new Produto());
    for (Object obj : listaProdutos) {
        Produto produto = (Produto) obj;
        comboBoxProdutos.getItems().add(produto.getNome());
        }
    }

    public void setUsuarioProduto(UsuarioProdutoAux usuProdAux) {
        this.usuProdSaidaTela = usuProdAux;
    }
    
    public UsuarioProdutoAux getUsuarioProduto() {
        return this.usuProdSaidaTela;
    }
}
