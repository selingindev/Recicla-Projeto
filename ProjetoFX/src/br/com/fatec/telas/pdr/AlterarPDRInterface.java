package br.com.fatec.telas.pdr;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import recicla.model.bean.PontoReciclagem;
import utils.NavigationUtil;

/**
 * Tela de alteração de Ponto de Reciclagem.
 * Simula a alteração de dados do ponto.
 */
public class AlterarPDRInterface {

    @FXML
    private TextField idField;
    @FXML
    private TextField idPEJField;
    @FXML
    private TextField novoNomeField;
    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleAlterar() {
        try {
            int id = Integer.parseInt(idField.getText());
            int idPEJ = Integer.parseInt(idPEJField.getText());
            String novoNome = novoNomeField.getText();
            

            // Simulação de alteração
            PontoReciclagem pr = new PontoReciclagem(id, idPEJ, novoNome);
            resultadoArea.setText("Ponto de reciclagem alterado (simulado):\nID: " + pr.getId() + "\nNovo ID PJ: " + pr.getIdPEJ() + "\nNovo nome: " + pr.getNome());
        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
