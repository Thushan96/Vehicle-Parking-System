package Controller;

import View.tm.OutputTM2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class OnDeliveryFormController {
    public TableView Ontable;
    public TableColumn VnumberClmn;
    public TableColumn VtypeClmn;
    public TableColumn parkingSlotClmn;
    public TableColumn parkTimeClmn;
    public static ArrayList<Output> outputArrayList3=ParkingControllerFormController.outputArrayList;



    public void initialize(){

            loadAllOnDelivery();
            VnumberClmn.setCellValueFactory(new PropertyValueFactory<>("Vno"));
            VtypeClmn.setCellValueFactory(new PropertyValueFactory<>("Vtype"));
            parkingSlotClmn.setCellValueFactory(new PropertyValueFactory<>("Pslot"));
            parkTimeClmn.setCellValueFactory(new PropertyValueFactory<>("Ptime"));


    }

    public void loadAllOnDelivery(){
        ObservableList<OutputTM2> outputObservableList2 = FXCollections.observableArrayList();

        L1:  for (Output temp : outputArrayList3) {
            if(temp.getParkedOrDelivery()==false){
                outputObservableList2.add(new OutputTM2(temp.getVno(),temp.getVType(),temp.getSno(),temp.getTime()));
            }else{
                continue L1;
            }
        }
        Ontable.setItems(outputObservableList2);

    }
}
