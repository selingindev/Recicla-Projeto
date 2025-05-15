package br.com.fatec.telas.logradouro;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import utils.NavigationUtil;

public class ConsultarLogradouroInterface {

    @FXML
    private TextField cepField;

    @FXML
    private void onConsultarClick() {
        String cep = cepField.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Consulta");
        alert.setHeaderText("Resultado da Consulta");
        alert.setContentText("Consultar CEP: " + cep);
        alert.showAndWait();
    }
      @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
    
}
