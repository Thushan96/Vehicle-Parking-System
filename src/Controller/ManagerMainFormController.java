package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ManagerMainFormController {
    public Button AddVehicleBtn;
    public Button AddDriverBtn;
    public Button LogOutBtn;
    public ComboBox<String> StattusCmb;

    static ArrayList<String> status=new ArrayList();
    static {
        status.add("In Parking");
        status.add("On Delivery");
    }

    public AnchorPane AnchorPane1;

    public void initialize(){
        ObservableList<String> oblist= FXCollections.observableList(status);
        StattusCmb.setItems(oblist);

    }

    public void AddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) AddVehicleBtn.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void AddDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) AddDriverBtn.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void LogOutVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingControllerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) LogOutBtn.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void ComboBoxAction(ActionEvent actionEvent) throws IOException {
        if(StattusCmb.getValue().equalsIgnoreCase("In Parking")){

           //Stage stage=(Stage)AnchorPane1.getScene().getWindow();
           Parent load=FXMLLoader.load(getClass().getResource("/View/OnDeliveryForm.fxml"));
            AnchorPane1.getChildren().add(load);
        }else{
            Parent load=FXMLLoader.load(getClass().getResource("/View/InparkingForm.fxml"));
            AnchorPane1.getChildren().add(load);
        }
    }
}
