package br.com.fatec.telas.pdr;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import recicla.model.bean.PontoReciclagem;
import utils.NavigationUtil;

/**
 * Tela de inserção de Ponto de Reciclagem.
 * Simula o cadastro de um novo ponto.
 */
public class InserirPDRInterface {

    @FXML
    private TextField nomeField;
    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleInserir() {
        try {
            String nome = nomeField.getText();

            // Simulação de inserção (ID fictício)
            PontoReciclagem pr = new PontoReciclagem(999, nome, "SimuladoQRCode");
            resultadoArea.setText("Ponto de reciclagem inserido (simulado):\nID: " + pr.getId() + "\nNome: " + pr.getNome());
        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
