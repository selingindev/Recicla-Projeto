package br.com.fatec.telas.pef_pdc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import recicla.model.bean.PEF_PDC;

public class ConsultarPEFPDCInterface {

    @FXML private TableView<PEF_PDC> table;
    @FXML private TableColumn<PEF_PDC, Long> colId;
    @FXML private Button btnNovo;

    private final ObservableList<PEF_PDC> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        table.setItems(data);
        btnNovo.setOnAction(e -> {
        });
    }
}
