package Controller;

import View.tm.DriverTM;
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

public class AddDriverFormController {
    public Button AddDriverBtn;
    public Button CancelBtn;
    public TextField Dnamebtn;
    public TextField DnicBtn;
    public TextField DlNobtn;
    public TextField AfressBtn;
    public TextField CnoBtn;
    public TableView DriverTbl;
    public TableColumn nameClmn;
    public TableColumn NICclmn;
    public TableColumn DlClmn;
    public TableColumn AdressClmn;
    public TableColumn ContactClmn;

    public static ArrayList<Driver> driverArrayList=ParkingControllerFormController.driverArrayList;
    public TableColumn DeleteClmn;

    public void initialize(){
        loadAllDrivers();
        nameClmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        NICclmn.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        DlClmn.setCellValueFactory(new PropertyValueFactory<>("DrivingLicenseNO"));
        AdressClmn.setCellValueFactory(new PropertyValueFactory<>("address"));
        ContactClmn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        DeleteClmn.setCellValueFactory(new PropertyValueFactory<>("btn"));

    }

    public void AddDriverAction(ActionEvent actionEvent) {
        if(Dnamebtn.getText()!=null || DnicBtn.getText()!=null|| DlNobtn.getText()!=null || AfressBtn.getText()!=null || CnoBtn.getText()!=null) {
            Driver driver = new Driver(Dnamebtn.getText(), DnicBtn.getText().toString(), DlNobtn.getText(), AfressBtn.getText(),CnoBtn.getText());
            Dnamebtn.clear();
            DnicBtn.clear();
            DlNobtn.clear();
            AfressBtn.clear();
            CnoBtn.clear();
            driverArrayList.add(driver);
            loadAllDrivers();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Please fill all data Correctly", ButtonType.CLOSE).show();
        }

    }

    public void CancelButtonAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagerMainForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) CancelBtn.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadAllDrivers(){
        ObservableList<DriverTM> driverTMS= FXCollections.observableArrayList();
        for (Driver temp:driverArrayList) {
            Button btn=new Button("Remove");
            driverTMS.add(new DriverTM(temp.getName(),temp.getNIC(),temp.getDrivingLicenseNO(),temp.getAddress(),temp.getContact(),btn));
            btn.setOnAction((e)->{
                driverArrayList.remove(temp);
                loadAllDrivers();
            });
        }

        DriverTbl.setItems(driverTMS);
    }
    }

