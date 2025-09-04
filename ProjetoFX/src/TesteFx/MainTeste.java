package TesteFx;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTeste extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

                            
            
            
URL url = getClass().getResource("/br/com/fatec/xmls/pef_pdc/ConsultarPEF_PDCInterface.fxml");
System.out.println("FXML URL: " + url);

            Parent root = FXMLLoader.load(getClass().getResource("/br/com/fatec/xmls/pef_pdc/ConsultarPEF_PDCInterface.fxml"));



            Scene scene = new Scene(root);
            primaryStage.setTitle("Tela de Teste");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
