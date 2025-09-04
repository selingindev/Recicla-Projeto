package br.com.fatec.telas.pdc;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import recicla.model.bean.PontoColeta;
import utils.NavigationUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ArthurSelingin
 */
public class AlterarPDCInterface {

    @FXML
    private TextField idField;
    @FXML
    private TextField novoNomeField;
    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleAlterar() {
        try {
            int id = Integer.parseInt(idField.getText());
            String novoNome = novoNomeField.getText();

            PontoColeta pc = new PontoColeta(id, 0, novoNome, "SimuladoQRCode");
            resultadoArea.setText("Ponto alterado (simulado):\nID: " + pc.getId() + "\nNovo nome: " + pc.getNome());
        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
