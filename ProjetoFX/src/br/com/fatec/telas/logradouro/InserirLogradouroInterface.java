package br.com.fatec.telas.logradouro;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import utils.NavigationUtil;

public class InserirLogradouroInterface {

    @FXML
    private TextField cepField;

    @FXML
    private TextField numeroField;

    @FXML
    private TextField complementoField;

    @FXML
    private void onInserirClick() {
        String cep = cepField.getText();
        String numero = numeroField.getText();
        String complemento = complementoField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inserção");
        alert.setHeaderText("Logradouro Inserido");
        alert.setContentText("CEP: " + cep + "\nNúmero: " + numero + "\nComplemento: " + complemento);
        alert.showAndWait();
    }
      @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
