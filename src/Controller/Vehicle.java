package Controller;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private String MaximumWeight;
    private String NoOfPassengers;
    private String Status;

    public Vehicle(String vehicleNumber, String vehicleType, String maximumWeight, String noOfPassengers) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        setMaximumWeight(maximumWeight);
        setNoOfPassengers(noOfPassengers);
    }

    public Vehicle(String status){
        this.setStatus(status);
    }

    public Vehicle() {
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


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
