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
public class BuscarPessoaInterface implements Initializable{
    @FXML
    private TextField txtId;

    @FXML
    private Button btBuscar;
    
    @FXML
    private Button btVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdLog;


    private ControllerPessoa controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = new ControllerPessoa();
        
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

        btBuscar.setOnAction(event -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                Pessoa pessoa = (Pessoa) controller.buscar(new Pessoa(id));

                if (pessoa != null) {
                    txtNome.setText(pessoa.getNome());
                    txtIdLog.setText(""+pessoa.getId_LOG());
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa não encontrada.");
                    limparCampos();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um ID válido.");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(BuscarPessoaInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void limparCampos() {
        txtNome.clear();
        txtIdLog.clear();
        txtId.clear();
    }
}
