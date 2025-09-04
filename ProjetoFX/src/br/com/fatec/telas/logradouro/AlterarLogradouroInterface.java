package br.com.fatec.telas.logradouro;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import utils.NavigationUtil;

public class AlterarLogradouroInterface {

    @FXML
    private TextField idField;

    @FXML
    private TextField cepField;

    @FXML
    private TextField numeroField;

    @FXML
    private TextField complementoField;

    @FXML
    private void onAlterarClick() {
        String id = idField.getText();
        String cep = cepField.getText();
        String numero = numeroField.getText();
        String complemento = complementoField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alteração");
        alert.setHeaderText("Logradouro Alterado");
        alert.setContentText("ID: " + id + "\nCEP: " + cep + "\nNúmero: " + numero + "\nComplemento: " + complemento);
        alert.showAndWait();
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }

}
