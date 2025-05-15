package br.com.fatec.telas.relacoes;

import br.com.fatec.telas.*;
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
import javax.swing.JOptionPane;
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
public class InserirRelacaoInterface implements Initializable {
    @FXML
    private Button btSalvar;

    @FXML
    private Label lbIdU;

    @FXML
    private TextField txtIdU;

    @FXML
    private Label lbObs;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        try {
            popularComboBoxProdutos();
            popularComboBoxUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void initComponentes () {
        comboBoxProdutos.setOnAction(event -> {
            produtoSelecionado = comboBoxProdutos.getSelectionModel().getSelectedItem();
            
            ControllerProduto produtoCont = new ControllerProduto();
            try {
               prodFinal = (Produto) produtoCont.buscarNome(produtoSelecionado);
               System.out.println(prodFinal.toString());
            } catch (SQLException ex) {
                Logger.getLogger(InserirRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        comboBoxUsuarios.setOnAction(event -> {
            login = comboBoxUsuarios.getSelectionModel().getSelectedItem();
            
            ControllerUsuario usuCont = new ControllerUsuario();
            try {
               loginFinal = (Usuario) usuCont.buscarNome(login);
               System.out.println(loginFinal.toString());
            } catch (SQLException ex) {
                Logger.getLogger(InserirRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                
        btSalvar.setOnAction((ActionEvent event) -> {
            usuProdCont = new ControllerUsuarioProduto();
            UsuarioProduto usuProd = new UsuarioProduto(
                        loginFinal.getId(),
                        prodFinal.getId(),
                        txtObs.getText(),
                        loginFinal,
                        prodFinal);
            
            try {
                usuProd = (UsuarioProduto) usuProdCont.inserir(usuProd);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, usuProd.getObs());
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
