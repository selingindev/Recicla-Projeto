package br.com.fatec.telas.pdr;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import recicla.model.bean.PontoReciclagem;
import utils.NavigationUtil;

/**
 * Tela de exclusão de Ponto de Reciclagem.
 * Simula a exclusão de um ponto com base no ID.
 */
public class ExcluirPDRInterface {

    @FXML
    private TextField idField;
    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleExcluir() {
        try {
            int id = Integer.parseInt(idField.getText());

            // Simulação de exclusão
            resultadoArea.setText("Ponto de reciclagem excluído (simulado):\nID: " + id);
        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
