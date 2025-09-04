package br.com.fatec.telas.pef_pdc;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import recicla.controller.ControllerPEF_PDC;
import recicla.model.bean.PEF_PDC;
import java.math.BigDecimal;

public class AlterarPEF_PDCInterface extends Application {

    @FXML
    private TableView<PEF_PDC> table;
    @FXML
    private TableColumn<PEF_PDC, Long> colId;
    @FXML
    private TextField tfCod, tfQuant, tfData;
    @FXML
    private Button btnEditar, btnVoltar;

    private PEF_PDC selected;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AlterarPEF_PDFInterface.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void handleAlter() throws Exception {
        selected = table.getSelectionModel().getSelectedItem();
        selected.setCod(Integer.parseInt(tfCod.getText()));
        selected.setQuant(Integer.parseInt(tfQuant.getText()));
        selected.setData(tfData.getText());

        ControllerPEF_PDC ctr = new ControllerPEF_PDC();
        PEF_PDC res = (PEF_PDC) ctr.alterar(selected);
        JOptionPane.showMessageDialog(null, res);
    }

    @FXML
    private void onVoltarClick() {
    }
}
