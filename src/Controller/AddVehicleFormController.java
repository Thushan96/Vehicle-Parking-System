package Controller;

import View.tm.VehicleTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AddVehicleFormController {
    public Button AddVehicleBtn;
    public Button CancelBtn;
    public TextField VnoBtn;
    public TextField VtypeBtn;
    public TextField WeightBtn;
    public TextField PassegerBtn;
    public TableView Vehicletable;
    public TableColumn VnoClmn;
    public TableColumn VtypeClmn;
    public TableColumn MaxWclmn;
    public TableColumn Passengerclmn;
    public ComboBox VtypeCmb;

    public static ArrayList<Vehicle> vehicleArrayList2=ParkingControllerFormController.vehicleArrayList;
    public TableColumn Deleteclmn;

    public static ArrayList<String> arrayList=new ArrayList();
    static {
        arrayList.add("Bus");
        arrayList.add("Van");
        arrayList.add("Cargo Lorry");
    }

    public void initialize(){
        loadAllVehicles();
        VnoClmn.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        VtypeClmn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        MaxWclmn.setCellValueFactory(new PropertyValueFactory<>("MaximumWeight"));
        Passengerclmn.setCellValueFactory(new PropertyValueFactory<>("NoOfPassengers"));
        Deleteclmn.setCellValueFactory(new PropertyValueFactory<>("btn"));

        ObservableList<String> obList= FXCollections.observableArrayList();
        for (String temp:arrayList) {
            obList.add(temp);
        }
        VtypeCmb.setItems(obList);
    }


    public void CancelButtonAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagerMainForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) CancelBtn.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void AddVehicleAction(ActionEvent actionEvent) {

        if(VnoBtn.getText()!=null || VtypeCmb.getValue().toString()!=null|| WeightBtn.getText()!=null || PassegerBtn.getText()!=null) {
            Vehicle vehicle = new Vehicle(VnoBtn.getText(), VtypeCmb.getValue().toString(), WeightBtn.getText(), PassegerBtn.getText());
            VnoBtn.clear();
            WeightBtn.clear();
            PassegerBtn.clear();
            vehicleArrayList2.add(vehicle);
            loadAllVehicles();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Please fill all data Correctly", ButtonType.CLOSE).show();
        }
    }


    public void loadAllVehicles(){
        ObservableList<VehicleTM> vehicleTMS= FXCollections.observableArrayList();
        for (Vehicle temp:vehicleArrayList2) {
            Button btn=new Button("Remove");
            vehicleTMS.add(new VehicleTM(temp.getVehicleNumber(),temp.getVehicleType(),temp.getMaximumWeight(),temp.getNoOfPassengers(),btn));
            btn.setOnAction((e)->{
                vehicleArrayList2.remove(temp);
                loadAllVehicles();
            });
        }

        Vehicletable.setItems(vehicleTMS);
    }
}
