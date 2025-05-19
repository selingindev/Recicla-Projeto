package br.com.fatec.telas.pef_pdc;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import recicla.model.bean.PEF_PDC;

public class InserirPEFPDCInterface {

    @FXML private TextField tfIdPef;
    @FXML private TextField tfIdCol;
    @FXML private TextField tfIdMat;
    @FXML private TextField tfIdPdc;
    @FXML private TextField tfCod;
    @FXML private TextField tfQuant;
    @FXML private TextField tfData;
    @FXML private Button btnSalvar;
    @FXML private Button btnCancelar;

    @FXML
    private void initialize() {
        btnSalvar.setOnAction(e -> salvar());
        btnCancelar.setOnAction(e -> cancelar());
    }

    private void salvar() {
        try {
            PEF_PDC novo = new PEF_PDC(
                0L,
                Long.parseLong(tfIdPef.getText()),
                Long.parseLong(tfIdCol.getText()),
                Long.parseLong(tfIdMat.getText()),
                Long.parseLong(tfIdPdc.getText()),
                tfCod.getText(),
                new BigDecimal(tfQuant.getText()),
                java.sql.Date.valueOf(tfData.getText())
            );
            showAlert("Sucesso", "Coleta inserida com sucesso.");
            cancelar();
        } catch (Exception ex) {
            showAlert("Erro", "Verifique os campos e tente novamente.");
        }
    }

    private void cancelar() {
        tfIdPef.clear();
        tfIdCol.clear();
        tfIdMat.clear();
        tfIdPdc.clear();
        tfCod.clear();
        tfQuant.clear();
        tfData.clear();
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
