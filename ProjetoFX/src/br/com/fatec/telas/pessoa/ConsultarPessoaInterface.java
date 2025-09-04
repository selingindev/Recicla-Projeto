/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas.pessoa;



import br.com.fatec.telas.LoginInterface;
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
import recicla.controller.ControllerPessoa;
import recicla.model.bean.Pessoa;

/**
 *
 * @author olgac
 */
public class ConsultarPessoaInterface implements Initializable {
    @FXML
    private Label lbNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TableView<Pessoa> listaUsuario;

    @FXML
    private TableColumn<Pessoa, String> tid;

    @FXML
    private TableColumn<Pessoa, String> tnome;

    @FXML
    private TableColumn<Pessoa, String> tIdLog;
    
    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerPessoa usuCont = null;
    
    ObservableList<Pessoa> oList = null;

    List<Pessoa> lista = new ArrayList();
    
    public static Pessoa pesSaidaTela;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        usuCont = new ControllerPessoa();

        btConsultar.setOnAction((ActionEvent event) -> {
            if (txtNome.getText().isEmpty()){
                try {
                    execListarTodos();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ConsultarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Pessoa usu = new Pessoa(txtNome.getText());
            try {
                montaLista(usu);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
            }
            
        });

        btAlterar.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuario.getSelectionModel().getSelectedCells().get(0);
            System.out.println(pos);
            int row = pos.getRow();
            setUsuario(listaUsuario.getItems().get(row));
            System.out.println("Usuário setado: " + pesSaidaTela.toString());
            URL fmlLocation = ProjetoFX.class.getResource("/br/com/fatec/xmls/pessoa/AlterarPessoaInterface.fxml");
            System.out.println("URL do fxmls"+ fmlLocation);
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/pessoa/AlterarPessoaInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(ConsultarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuario.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Pessoa usu = listaUsuario.getItems().get(row);
            try {
                usuCont.excluir(usu);
                listaUsuario.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No Excluir");

            }
        });

        btVoltar.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(ConsultarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    public void montaLista(Pessoa usu) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = usuCont.listar(usu);
        for (Object obj : listaObj){
            Pessoa usuario = (Pessoa) obj;
            lista.add(usuario);
        }
        System.out.println(lista);
        
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado");
        }
          
        oList = FXCollections.observableArrayList(lista);
        System.out.println(oList);
        tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        System.out.println("TID: " + tid);
        tnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        System.out.println(tnome);
        
        tIdLog.setCellValueFactory(new PropertyValueFactory<>("id_LOG"));
        System.out.println(tIdLog);
        
        listaUsuario.setItems(oList);
    }
    
    
    
    public void execListarTodos() throws SQLException, ClassNotFoundException{
        List<Object> listaObj = usuCont.listarTodos();
        for (Object obj : listaObj){
            Pessoa usuario = (Pessoa) obj;
            lista.add(usuario);
        }
        System.out.println(lista);
        
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado");
        }
          
        oList = FXCollections.observableArrayList(lista);
        System.out.println(oList);
        tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        System.out.println("TID: " + tid);
        tnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        System.out.println(tnome);
        
        tIdLog.setCellValueFactory(new PropertyValueFactory<>("id_LOG"));
        System.out.println(tIdLog);
        
        listaUsuario.setItems(oList);
    }
    

    public void setUsuario(Pessoa usuP) {
        ConsultarPessoaInterface.pesSaidaTela = usuP;
    }
    
    
}
