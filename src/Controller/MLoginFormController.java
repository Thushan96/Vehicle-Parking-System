package Controller;

import com.sun.applet2.preloader.event.ApplicationExitEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MLoginFormController {

    public Button loginBtn;
    public Button cancelBtn;
    public TextField UnameTxt;

    public void Mlogin(ActionEvent actionEvent) throws IOException {
        if(UnameTxt.getText().equals("admin")){
            URL resource = getClass().getResource("../view/ManagerMainForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginBtn.getScene().getWindow();
            window.setScene(new Scene(load));
        }else{
            new Alert(Alert.AlertType.WARNING,"Invalid username or password Try Again", ButtonType.CLOSE).showAndWait();
        }
    }

    public void Cancellogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingControllerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) cancelBtn.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
