package br.com.fatec.telas.pdc;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import recicla.model.bean.PontoColeta;
import utils.NavigationUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ArthurSelingin
 */
public class ListarPDCInterface {

    @FXML
    private TextArea resultadoArea;

    @FXML
    private void handleListar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            PontoColeta pc = new PontoColeta(i, "Log" + i, "Nome" + i, "QRCode" + i);
            sb.append("ID: ").append(pc.getId())
                    .append(", IDLOG: ").append(pc.getIdLog())
                    .append(", Nome: ").append(pc.getNome())
                    .append(", QRCode: ").append(pc.getQrCode())
                    .append("\n");
        }
    }

    @FXML
    private void onVoltarClick(javafx.event.ActionEvent event) {
        NavigationUtil.voltarParaTelaInicial(event);
    }
}
