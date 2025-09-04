package br.com.fatec.telas.pef_pdc;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import recicla.controller.ControllerPEF_PDC;
import recicla.model.bean.PEF_PDC;
import java.math.BigDecimal;

public class InserirPEF_PDCInterface extends Application {

    @FXML private TextField tfIdPef, tfIdCol, tfIdMat, tfIdPdc, tfCod, tfQuant, tfData;
    @FXML private Button btnSalvar, btnVoltar;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("InserirPEF_PDFInterface.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML private void handleInsert() throws Exception {
        PEF_PDC obj = new PEF_PDC(
          Integer.parseInt(tfIdPef.getText()),   // idPef
    Integer.parseInt(tfIdCol.getText()),   // idCol
    Integer.parseInt(tfIdMat.getText()),   // idMat
    Integer.parseInt(tfIdPdc.getText()),   // idPdc
    Integer.parseInt(tfCod.getText()),     // cod
    Integer.parseInt(tfQuant.getText()), 
    tfData.getText() 
        );
        ControllerPEF_PDC ctr = new ControllerPEF_PDC();
        PEF_PDC res = (PEF_PDC) ctr.inserir(obj);
        JOptionPane.showMessageDialog(null, res);
    }

    @FXML private void onVoltarClick() {
        // NavigationUtil.voltarParaTelaInicial(null);
    }
}
