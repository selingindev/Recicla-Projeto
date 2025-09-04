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
            PontoReciclagem pr = new PontoReciclagem();
            sb.append("ID: ").append(pr.getId())
              .append(", ID PJ: ").append(pr.getIdPEJ())     
              .append(", Nome: ").append(pr.getNome())
              .append("\n");
        }
        resultadoArea.setText(sb.toString());
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
