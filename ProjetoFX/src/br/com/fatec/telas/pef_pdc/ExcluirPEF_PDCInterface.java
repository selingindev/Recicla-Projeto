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
import javax.swing.JOptionPane;
import recicla.controller.ControllerPEF_PDC;
import recicla.model.bean.PEF_PDC;

public class ExcluirPEF_PDCInterface extends Application {

    @FXML private TableView<PEF_PDC> table;
    @FXML private TableColumn<PEF_PDC, Long> colId;
    @FXML private Button btnExcluir, btnVoltar;

    private PEF_PDC selected;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ExcluirPEF_PDFInterface.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML private void handleDelete() throws Exception {
        selected = table.getSelectionModel().getSelectedItem();
        ControllerPEF_PDC ctr = new ControllerPEF_PDC();
        ctr.excluir(selected);
        JOptionPane.showMessageDialog(null, "Excluído");
    }

    @FXML private void onVoltarClick() {
    }
}
