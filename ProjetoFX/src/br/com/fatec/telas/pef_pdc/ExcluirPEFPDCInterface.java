package br.com.fatec.telas.pef_pdc;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import recicla.model.bean.PEF_PDC;

public class ExcluirPEFPDCInterface {

    @FXML private TableView<PEF_PDC> table;
    @FXML private TableColumn<PEF_PDC, Long> colId;
    @FXML private Button btnExcluir;
    @FXML private Button btnCancelar;

    private PEF_PDC selected;

    @FXML
    private void initialize() {
        table.getSelectionModel().selectedItemProperty().addListener((o, old, neu) -> selected = neu);
        btnExcluir.setOnAction(e -> excluir());
        btnCancelar.setOnAction(e -> table.getSelectionModel().clearSelection());
    }

    private void excluir() {
        if (selected == null) {
            showAlert("Aviso", "Selecione uma coleta.");
            return;
        }
        showAlert("Sucesso", "Coleta excluída.");
        table.getItems().remove(selected);
        table.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
