package br.com.fatec.telas.pef_pdc;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import recicla.controller.ControllerPEF_PDC;
import recicla.model.bean.PEF_PDC;

public class ConsultarPEF_PDCInterface extends Application {

    @FXML private TableView<PEF_PDC> table;
    @FXML private TableColumn<PEF_PDC, Long> colId;
    @FXML private Button btnVoltar;

    private ObservableList<PEF_PDC> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ConsultarPEF_PDFInterface.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML private void initialize() throws Exception {
        ControllerPEF_PDC ctr = new ControllerPEF_PDC();
        data.addAll((java.util.List<PEF_PDC>)(Object)ctr.listar(null));
        table.setItems(data);
    }

    @FXML private void onVoltarClick() {
    }
}
