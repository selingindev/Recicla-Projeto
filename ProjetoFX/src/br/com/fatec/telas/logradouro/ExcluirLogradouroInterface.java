package br.com.fatec.telas.logradouro;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import utils.NavigationUtil;

public class ExcluirLogradouroInterface {

    @FXML
    private TextField idField;

    @FXML
    private void onExcluirClick() {
        String id = idField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exclusão");
        alert.setHeaderText("Logradouro Excluído");
        alert.setContentText("ID: " + id);
        alert.showAndWait();
    }
      @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
