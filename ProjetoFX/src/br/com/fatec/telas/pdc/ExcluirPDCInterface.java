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
public class ExcluirPDCInterface {

    @FXML
    private TextField idField;
    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleExcluir() {
        try {
            int id = Integer.parseInt(idField.getText());
            PontoColeta pc = new PontoColeta(id, 0, "SimuladoNome", "SimuladoQRCode");
            resultadoArea.setText("Ponto excluído (simulado):\nID: " + pc.getId());
        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
        }
    }
        @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
