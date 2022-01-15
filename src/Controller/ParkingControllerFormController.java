package Controller;

import com.sun.deploy.net.proxy.RemoveCommentReader;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import jdk.nashorn.internal.ir.CatchNode;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class ParkingControllerFormController{
    public Label DateLbl;

    public AnchorPane ParkingMain;

    public Button MangementBtn;
    public Label VehicleTypeLbl;
    public Label VslotNoLbl;
    public Button ParkVehicleBtn;
    public Button OnDeliveryShiftBtn;
    public ComboBox VehicleCmb;
    public Label ParkingSlotLbl;
    int slot;
    String check=null;
    String vd;
    String time;

    static int[] arrayInt= new int[14];
   public static ArrayList<Output> outputArrayList=new ArrayList();
    //public static ArrayList<Output> outputArrayList2=new ArrayList();

    public static ArrayList<Vehicle> vehicleArrayList=new ArrayList();
    static {
        vehicleArrayList.add(new Vehicle("NA-3434","Bus","3500","60"));
        vehicleArrayList.add(new Vehicle("KA-4563","Van","1000","7"));
        vehicleArrayList.add(new Vehicle("58-3567","Van","1500","4"));
        vehicleArrayList.add(new Vehicle("GF-4358","Van","800","4"));
        vehicleArrayList.add(new Vehicle("CCB-3568","Van","1800","8"));
        vehicleArrayList.add(new Vehicle("LM-6679","Van","1500","4"));
        vehicleArrayList.add(new Vehicle("QA-3369","Van","1800","6"));
        vehicleArrayList.add(new Vehicle("KB-3668","Cargo Lorry","2500","2"));
        vehicleArrayList.add(new Vehicle("JJ-9878","Cargo Lorry","3000","2"));
        vehicleArrayList.add(new Vehicle("GH-5772","Cargo Lorry","4000","3"));
        vehicleArrayList.add(new Vehicle("XY-4456","Cargo Lorry","3500","2"));
        vehicleArrayList.add(new Vehicle("YQ-3536","Cargo Lorry","2000","2"));
        vehicleArrayList.add(new Vehicle("CBB-3566","Cargo Lorry","2500","2"));
        vehicleArrayList.add(new Vehicle("QH-3444","Cargo Lorry","5000","4"));

    }

    public static ArrayList<Driver> driverArrayList=new ArrayList();

    static{
        driverArrayList.add(new Driver("Sumith Kumara","7835348345V","B6474845","Panadura","0725637456"));
        driverArrayList.add(new Driver("Amila Pathirana","8826253734V","B3354674","Galle","0717573583"));
        driverArrayList.add(new Driver("Jthmal Perera","9283289272V","B3674589","Horana","0772452457"));
        driverArrayList.add(new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara","0782686390"));
        driverArrayList.add(new Driver("Charith Sudara","9573536833V","B6835836","Baththaramulla","0771536662"));
        driverArrayList.add(new Driver("Prashan Dineth ","9362426738V","B2683536","Wadduwa","0715353434"));
        driverArrayList.add(new Driver("Chethiya Dilan ","9162353436V","B6836836","Panadura","0772436737"));
        driverArrayList.add(new Driver("Dushantha Perera ","9255556343V","B3334435","Matara","0777245343"));
        driverArrayList.add(new Driver("Dinesh Udara  ","9026344373V","B5343783","Hettimulla","0713456878"));
        driverArrayList.add(new Driver("Udana Chathuranga ","9692653338V ","B7888632","Kottawa","0772442444"));
        driverArrayList.add(new Driver("Mohommad Riaz","9124537733V ","B3638537 ","Kaluthara","0777544222"));
        driverArrayList.add(new Driver("Sandun Kumara ","9563524267V ","B2263333 ","Panadura","0772325544"));
        driverArrayList.add(new Driver("Priyanga Perera  ","9135343537V  ","B3853753  ","Matara ","0723344562"));
    }

    public ComboBox DriverCmb;



    public void initialize() {
        {
            Thread clock=new Thread(){
                public void run(){
                    try {
                        while (true) {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss a");
                            Date date = new Date();
                            String myString = formatter.format(date);
                            Platform.runLater(() -> {
                                DateLbl.setText(myString);
                            });
                            sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            clock.start();

        }

        autoRunAnchor();

    }




    public void parkVehicleAction(ActionEvent actionEvent) {
        for (Vehicle v:vehicleArrayList) {
            if(check==v.getVehicleNumber()){
                v.setStatus("parked");
                System.out.println(v.getStatus());
            }
        }


        checkSlot();
        time=DateLbl.getText();
       L1: for (Output o:outputArrayList) {
            if(VehicleCmb.getValue()==o.getVno()){
                outputArrayList.remove(o);
                break L1;
            }
        }
        outputArrayList.add(new Output((String) VehicleCmb.getValue(),(String) VehicleTypeLbl.getText(),(String)DriverCmb.getValue(),(String) VslotNoLbl.getText(),time,false));
        System.out.println(VehicleTypeLbl.getText());
        autoRunAnchor();

    }

    public void onDeliveryShiftAction(ActionEvent actionEvent) {
        time=DateLbl.getText();
      if(DriverCmb.getValue()!=null){
          for (Vehicle v:vehicleArrayList) {
              if(check==v.getVehicleNumber()){
                  v.setStatus("delivery");
                  System.out.println(v.getStatus());
              }
          }

          L1: for (Output o:outputArrayList) {
              if(VehicleCmb.getValue()==o.getVno()){
                  outputArrayList.remove(o);
                  break L1;
              }
          }

          outputArrayList.add(new Output((String) VehicleCmb.getValue(),(String) VehicleTypeLbl.getText(),(String)DriverCmb.getValue(),VslotNoLbl.getText(),time,true));
          System.out.println(VehicleTypeLbl.getText());
      }else{
          new Alert(Alert.AlertType.ERROR,"Select Your name", ButtonType.CLOSE).show();
          return;
      }


        autoRunAnchor();
    }

    public void ManagementLoginAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MangementBtn.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void SelectDriverOnAction(ActionEvent actionEvent) {

    }

    public void autoRunAnchor(){
        ObservableList<String> obList= FXCollections.observableArrayList();
        for (Vehicle temp:vehicleArrayList) {
            obList.add(temp.getVehicleNumber());
        }
        VehicleCmb.setItems(obList);

        ObservableList<String> obList2= FXCollections.observableArrayList();
        for (Driver temp:driverArrayList
        ) {
            obList2.add(temp.getName());
        }
        DriverCmb.setItems(obList2);


        VehicleCmb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            check = (String) VehicleCmb.getSelectionModel().getSelectedItem();
            for (Vehicle temp:vehicleArrayList) {
                if(newValue==temp.getVehicleNumber()){
                    VehicleTypeLbl.setText(temp.getVehicleType());

                    if(temp.getStatus()=="delivery"){
                        ParkingSlotLbl.setVisible(false);
                        VslotNoLbl.setVisible(false);
                        checkSlot2();
                        ParkVehicleBtn.setVisible(true);
                        OnDeliveryShiftBtn.setVisible(false);
                        L1:for (Output output:outputArrayList) {
                            if(temp.getVehicleNumber()==output.getVno()){
                                DriverCmb.setValue(output.getName());
                                break L1;
                            }else{
                                continue L1;
                            }
                        }
                    }else if(temp.getStatus()=="parked"){
                        OnDeliveryShiftBtn.setVisible(true);
                        ParkVehicleBtn.setVisible(false);
                        ParkingSlotLbl.setVisible(true);
                        VslotNoLbl.setVisible(true);
                    }else{
                        OnDeliveryShiftBtn.setVisible(true);
                        ParkVehicleBtn.setVisible(true);
                        VslotNoLbl.setText("");
                        ParkingSlotLbl.setVisible(false);
                    }

                }
            }
        });

    }
    public void checkSlot(){
        if(VehicleTypeLbl.getText()=="Van"){
            if(arrayInt[0]==0){
                VslotNoLbl.setText(1+"");
                arrayInt[0]=1;
            }else if(arrayInt[1]==0){
                VslotNoLbl.setText(2+"");
                arrayInt[1]=2;
            }else if(arrayInt[2]==0){
                VslotNoLbl.setText(3+"");
                arrayInt[2]=3;
            }else if(arrayInt[3]==0){
                VslotNoLbl.setText(4+"");
                arrayInt[3]=4;
            }else if (arrayInt[11]==0){
                VslotNoLbl.setText(12+"");
                arrayInt[11]=12;
            }else if (arrayInt[12]==0){
                VslotNoLbl.setText(13+"");
                arrayInt[12]=13;
            }
        }else if(VehicleTypeLbl.getText().equals("Cargo Lorry")){
            if(arrayInt[4]==0){
                VslotNoLbl.setText(5+"");
                arrayInt[4]=5;
            }else if(arrayInt[5]==0){
                VslotNoLbl.setText(6+"");
                arrayInt[5]=6;
            }else if(arrayInt[6]==0){
                VslotNoLbl.setText(7+"");
                arrayInt[6]=7;
            }else if(arrayInt[7]==0){
                VslotNoLbl.setText(8+"");
                arrayInt[7]=8;
            }else if(arrayInt[8]==0){
                VslotNoLbl.setText(9+"");
                arrayInt[8]=9;
            }else if(arrayInt[9]==0){
                VslotNoLbl.setText(10+"");
                arrayInt[9]=10;
            }else if(arrayInt[10]==0){
                VslotNoLbl.setText(11+"");
                arrayInt[10]=11;
            }
        }else if(VehicleTypeLbl.getText()=="Bus"){
            if(arrayInt[13]==0){
                VslotNoLbl.setText(14+"");
                arrayInt[13]=14;
            }
        }else{
            VslotNoLbl.setText("");
        }

    }


    public void checkSlot2(){
        if(VehicleTypeLbl.getText()=="Van"){
            if(arrayInt[0]==0){
                VslotNoLbl.setText(1+"");
            }else if(arrayInt[1]==0){
                VslotNoLbl.setText(2+"");
            }else if(arrayInt[2]==0){
                VslotNoLbl.setText(3+"");
            }else if(arrayInt[3]==0){
                VslotNoLbl.setText(4+"");
            }else if (arrayInt[11]==0){
                VslotNoLbl.setText(12+"");
            }else if (arrayInt[12]==0){
                VslotNoLbl.setText(13+"");
            }
        }else if(VehicleTypeLbl.getText().equals("Cargo Lorry")){
            if(arrayInt[4]==0){
                VslotNoLbl.setText(5+"");
            }else if(arrayInt[5]==0){
                VslotNoLbl.setText(6+"");
            }else if(arrayInt[6]==0){
                VslotNoLbl.setText(7+"");
            }else if(arrayInt[7]==0){
                VslotNoLbl.setText(8+"");
            }else if(arrayInt[8]==0){
                VslotNoLbl.setText(9+"");
            }else if(arrayInt[9]==0){
                VslotNoLbl.setText(10+"");
            }else if(arrayInt[10]==0){
                VslotNoLbl.setText(11+"");
            }
        }else if(VehicleTypeLbl.getText()=="Bus"){
            if(arrayInt[13]==0){
                VslotNoLbl.setText(14+"");
            }
        }else{
            VslotNoLbl.setText("");
        }

    }


}
