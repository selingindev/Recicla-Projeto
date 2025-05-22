package br.com.fatec.telas.pdr;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import recicla.model.bean.PontoReciclagem;
import utils.NavigationUtil;

/**
 * Tela de consulta de Ponto de Reciclagem.
 * Simula a consulta de um ponto com base no ID e nome.
 */
public class ConsultarPDRInterface {

    @FXML
    private TextField idField;
    @FXML
    private TextField novoNomeField;
    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleConsultar() {
        try {
            int id = Integer.parseInt(idField.getText());
  
            // Simulação de consulta
            PontoReciclagem pr = new PontoReciclagem(id);
            resultadoArea.setText("Ponto consultado (simulado):\nID: " + pr.getId());
        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
