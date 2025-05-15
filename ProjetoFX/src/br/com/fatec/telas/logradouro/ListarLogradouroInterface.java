package br.com.fatec.telas.logradouro;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import utils.NavigationUtil;

public class ListarLogradouroInterface {

    @FXML
    private TextArea resultadoArea;

    @FXML
    private void onListarClick() {
        // Simulação de listagem (aqui entraria chamada ao DAO)
        String resultado = "1 - 01001-000, 123, Apto 1\n" +
                           "2 - 01002-000, 456, Casa\n" +
                           "3 - 01003-000, 789, Fundos";

        resultadoArea.setText(resultado);
    }
      @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
