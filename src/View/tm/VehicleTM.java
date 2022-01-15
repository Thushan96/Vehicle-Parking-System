package View.tm;

import javafx.scene.control.Button;

public class VehicleTM {
    private String vehicleNumber;
    private String vehicleType;
    private String MaximumWeight;
    private String NoOfPassengers;
    private Button btn;

    public VehicleTM(String vehicleNumber, String vehicleType, String maximumWeight, String noOfPassengers, Button btn) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        setMaximumWeight(maximumWeight);
        setNoOfPassengers(noOfPassengers);
        this.setBtn(btn);
    }

    public VehicleTM() {
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaximumWeight() {
        return MaximumWeight;
    }

    public void setMaximumWeight(String maximumWeight) {
        MaximumWeight = maximumWeight;
    }

    public String getNoOfPassengers() {
        return NoOfPassengers;
    }

    public void setNoOfPassengers(String noOfPassengers) {
        NoOfPassengers = noOfPassengers;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
