package br.com.fatec.telas.pef_pdc;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import recicla.model.bean.PEF_PDC;

public class ListarPEFPDCInterface {

    @FXML private TableView<PEF_PDC> table;
    @FXML private TableColumn<PEF_PDC, Long> colId;

    private final ObservableList<PEF_PDC> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        table.setItems(data);
    }
}
