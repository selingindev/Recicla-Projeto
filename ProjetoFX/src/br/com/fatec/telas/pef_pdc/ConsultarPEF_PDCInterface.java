package br.com.fatec.telas.pef_pdc;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import recicla.controller.ControllerPEF_PDC;
import recicla.model.bean.PEF_PDC;

public class ConsultarPEF_PDCInterface {

    @FXML
    private TableView<PEF_PDC> table;
    @FXML
    private TableColumn<PEF_PDC, Integer> colId;
    @FXML
    private TableColumn<PEF_PDC, Integer> colCod;
    @FXML
    private TableColumn<PEF_PDC, Integer> colQuant;
    @FXML
    private TableColumn<PEF_PDC, String> colData;
    @FXML
    private Button btnVoltar;

    private ObservableList<PEF_PDC> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCod.setCellValueFactory(new PropertyValueFactory<>("cod"));
        colQuant.setCellValueFactory(new PropertyValueFactory<>("quant"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));

        ControllerPEF_PDC ctr = new ControllerPEF_PDC();
        try {
            List<PEF_PDC> lista = (List<PEF_PDC>) (List<?>) ctr.listar(null);
            data.addAll(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(data);
    }

    @FXML
    private void onVoltarClick() {
        // Fecha a janela atual
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
    }
}
