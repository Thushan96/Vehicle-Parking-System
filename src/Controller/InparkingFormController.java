package Controller;


import View.tm.OutputTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.ArrayList;

public class InparkingFormController {

    public static ArrayList<Output> outputArrayList2 = ParkingControllerFormController.outputArrayList;
    public TableView InparkingTable;
    public TableColumn VnoColumn;
    public TableColumn DnameColumn;
    public TableColumn LtimeColumn;
    public TableColumn Vtypeclmn;


    public void initialize() {
        loadAllParked();
            VnoColumn.setCellValueFactory(new PropertyValueFactory<>("Vno"));
            Vtypeclmn.setCellValueFactory(new PropertyValueFactory<>("Vtype"));
            DnameColumn.setCellValueFactory(new PropertyValueFactory<>("PDname"));
            LtimeColumn.setCellValueFactory(new PropertyValueFactory<>("Ptime"));
    }


    public void loadAllParked() {
        ObservableList<OutputTM> outputObservableList = FXCollections.observableArrayList();

      L1:  for (Output temp : outputArrayList2) {
            if(temp.getParkedOrDelivery()==true){
                outputObservableList.add(new OutputTM(temp.getVno(),temp.getVType(),temp.getName(),temp.getTime()));

            }else{
                continue L1;
            }
        }
        InparkingTable.setItems(outputObservableList);

        for (OutputTM temp:outputObservableList) {
            System.out.println(temp.getVtype());
        }
    }


}
