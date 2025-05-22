package br.com.fatec.telas.pdr;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import recicla.model.bean.PontoReciclagem;
import utils.NavigationUtil;

/**
 * Tela de listagem de Pontos de Reciclagem.
 * Simula a exibição de pontos de reciclagem cadastrados.
 */
public class ListarPDRInterface {

    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleListar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            // Simulando dados
            PontoReciclagem pr = new PontoReciclagem(i, "Nome" + i, "QRCode" + i);
            sb.append("ID: ").append(pr.getId())
              .append(", Nome: ").append(pr.getNome())
              .append(", QRCode: ").append(pr.getQrCode())
              .append("\n");
        }
        resultadoArea.setText(sb.toString());
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
