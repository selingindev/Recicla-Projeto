package br.com.fatec.telas.pef_pdc;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import recicla.model.bean.PEF_PDC;

public class AlterarPEFPDCInterface {

    @FXML private TableView<PEF_PDC> table;
    @FXML private TableColumn<PEF_PDC, Long> colId;
    @FXML private TextField tfCod;
    @FXML private TextField tfQuant;
    @FXML private TextField tfData;
    @FXML private Button btnEditar;
    @FXML private Button btnCancelar;

    private PEF_PDC selected;

    @FXML
    private void initialize() {
        table.getSelectionModel().selectedItemProperty().addListener((o, old, neu) -> {
            selected = neu;
            if (neu != null) {
                tfCod.setText(neu.getCod());
                tfQuant.setText(neu.getQuant().toString());
                tfData.setText(neu.getData().toString());
            }
        });
        btnEditar.setOnAction(e -> editar());
        btnCancelar.setOnAction(e -> limpar());
    }

    private void editar() {
        if (selected == null) {
            showAlert("Aviso", "Selecione uma coleta.");
            return;
        }
        try {
            selected.setCod(tfCod.getText());
            selected.setQuant(new BigDecimal(tfQuant.getText()));
            selected.setData(java.sql.Date.valueOf(tfData.getText()));
            showAlert("Sucesso", "Coleta alterada.");
            limpar();
        } catch (Exception ex) {
            showAlert("Erro", "Falha ao alterar.");
        }
    }

    private void limpar() {
        table.getSelectionModel().clearSelection();
        tfCod.clear();
        tfQuant.clear();
        tfData.clear();
        selected = null;
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
