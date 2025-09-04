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
public class InserirPDCInterface {

    @FXML
    private TextField idField;
    @FXML
    private TextField idLogField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField qrCodeField;
    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleInserir() {
        try {
            int id = Integer.parseInt(idField.getText());
            int idLog = Integer.parseInt(idLogField.getText());
            String nome = nomeField.getText();
            String qrCode = qrCodeField.getText();

            PontoColeta pc = new PontoColeta(id, idLog, nome, qrCode);
            resultadoArea.setText("Ponto inserido (simulado):\nID: " + pc.getId() + "\nIDLOG: " + pc.getIdLog()
                    + "\nNome: " + pc.getNome() + "\nQRCode: " + pc.getQrCode());
        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
        }
    }
        @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
