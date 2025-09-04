package utils;



import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NavigationUtil {

    public static void voltarParaTelaInicial(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(NavigationUtil.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
