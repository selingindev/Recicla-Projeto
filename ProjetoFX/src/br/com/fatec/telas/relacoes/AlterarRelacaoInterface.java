package br.com.fatec.telas.relacoes;

import padraomvc.model.bean.UsuarioProduto;
import padraomvc.controller.ControllerUsuarioProduto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import padraomvc.controller.ControllerProduto;
import padraomvc.controller.ControllerUsuario;
import padraomvc.model.bean.Produto;
import padraomvc.model.bean.Usuario;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Bruno Pequeno
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class AlterarRelacaoInterface implements Initializable {

    @FXML
    private Button btSalvar;
    
    @FXML
    private Label lbObs;
    
    @FXML
    private Label lbIdU;
    
    @FXML
    private Label lbIdP;
    
    @FXML
    private Label lbLogin;
    
    @FXML
    private Label lbNomeP;

    @FXML
    private TextField txtObs;

    @FXML
    private Button btVoltar;
    
    @FXML
    private ComboBox<String> comboBoxProdutos;
     
    private String produtoSelecionado;
    
    @FXML
    private ComboBox<String> comboBoxUsuarios;
    
    private String login;

    ControllerUsuarioProduto usuProdCont = null;
    
    private Produto prodFinal;
    
    private Usuario loginFinal;
    
    @FXML
    private Label lbIdT;

    @FXML
    private Label lbId;
    
    UsuarioProduto usuProd = null;
    
    UsuarioProdutoAux usuProdAux = null;
    
    UsuarioProduto usuProdFinal = null;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        try { 
            popularComboBoxUsuarios();
            popularComboBoxProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void initComponentes (){
        usuProdCont = new ControllerUsuarioProduto();
        ConsultarRelacaoInterface telaAnterior = new ConsultarRelacaoInterface();
        usuProdAux = telaAnterior.getUsuarioProduto();
        //System.out.println(usuProdAux);
            try {
                usuProdFinal = (UsuarioProduto) usuProdCont.buscarId(usuProdAux.getId());
                lbIdT.setText(String.valueOf(usuProdFinal.getId()));
                lbLogin.setText(String.valueOf(usuProdCont.buscarUsuario(usuProdFinal.getIdU())));
                lbNomeP.setText(String.valueOf(usuProdCont.buscarProduto(usuProdFinal.getIdP())));
                txtObs.setText(usuProdFinal.getObs());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        comboBoxProdutos.setOnAction(event -> {
            produtoSelecionado = comboBoxProdutos.getSelectionModel().getSelectedItem();
            
            ControllerProduto prodCont = new ControllerProduto();
            try {
               prodFinal = (Produto) prodCont.buscarNome(produtoSelecionado);  
            } catch (SQLException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        comboBoxUsuarios.setOnAction(event -> {
            login = comboBoxUsuarios.getSelectionModel().getSelectedItem();
            
            ControllerUsuario usuCont = new ControllerUsuario();
            try {
               loginFinal = (Usuario) usuCont.buscarNome(login);
            } catch (SQLException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btSalvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                usuProd = new UsuarioProduto(
                        usuProdFinal.getId(),
                        loginFinal.getId(),
                        prodFinal.getId(),
                        txtObs.getText(),
                        loginFinal,
                        prodFinal);
                try {
                    usuProdCont.alterar(usuProd);
                } catch (SQLException ex) {
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void popularComboBoxProdutos() throws SQLException, ClassNotFoundException {
    ControllerProduto prodCont = new ControllerProduto();
    List<Object> listaProdutos = prodCont.listarTudo(new Produto());
    for (Object obj : listaProdutos) {
        Produto produto = (Produto) obj;
        comboBoxProdutos.getItems().add(produto.getNome());

        }
    }
    
    private void popularComboBoxUsuarios() throws SQLException, ClassNotFoundException {
    ControllerUsuario usuCont = new ControllerUsuario();
    List<Object> listaUsuarios = usuCont.listarTudo(new Usuario());
    for (Object obj : listaUsuarios) {
        Usuario usuario = (Usuario) obj;
        comboBoxUsuarios.getItems().add(usuario.getLogin());
        }
    }
}
    
