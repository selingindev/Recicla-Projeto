/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas.pessoa;




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
import recicla.controller.ControllerPessoa;
import recicla.model.bean.Pessoa;

/**
 *
 * @author olgac
 */
public class AlterarPessoaInterface implements Initializable {
        @FXML
    private Button btSalvar;

    @FXML
    private Label lbNome;

    @FXML
    private TextField txtNome;

    @FXML
    private Label lbIdLog;

    @FXML
    private TextField txtIdLog;

    
    
    @FXML
    private Button btVoltar;
    
    @FXML
    private TextField txtId;

    @FXML
    private Label lbId;

    ControllerPessoa usuPes;
    
    Pessoa pes = ConsultarPessoaInterface.pesSaidaTela;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initComponentes(); 
    }    

    private void initComponentes (){

        usuPes = new ControllerPessoa();
        
        ConsultarPessoaInterface telaAnterior = new ConsultarPessoaInterface();
        setPessoa(pes);

        btVoltar.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(AlterarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btSalvar.setOnAction((ActionEvent event) -> {
            pes = new Pessoa(Integer.parseInt(txtId.getText()),
                    txtNome.getText(),
                    Integer.parseInt(txtIdLog.getText()));
            
            try {
                Pessoa pesSaida = (Pessoa) usuPes.alterar(pes);
                JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso: " + pesSaida);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlterarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(AlterarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    public void setPessoa(Pessoa pes) {
        JOptionPane.showMessageDialog(null, pes.toString());
        this.txtId.setText(""+pes.getId());
        this.txtNome.setText(pes.getNome());
        this.txtIdLog.setText(""+pes.getId_LOG());
    }
}
