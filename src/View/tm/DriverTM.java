package View.tm;

import javafx.scene.control.Button;

public class DriverTM {
    private String name;
    private String NIC;
    private String DrivingLicenseNO;
    private String address;
    private String contact;
    private Button btn;

    public DriverTM(String name, String NIC, String drivingLicenseNO, String address, String contact, Button btn) {
        this.setName(name);
        this.setNIC(NIC);
        setDrivingLicenseNO(drivingLicenseNO);
        this.setAddress(address);
        this.setContact(contact);
        this.setBtn(btn);
    }

    public DriverTM() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDrivingLicenseNO() {
        return DrivingLicenseNO;
    }

    public void setDrivingLicenseNO(String drivingLicenseNO) {
        DrivingLicenseNO = drivingLicenseNO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
