package Controller;

import java.util.ArrayList;

public class Driver {
    private String name;
    private String NIC;
    private String DrivingLicenseNO;
    private String address;
    private String contact;

    public Driver(String name, String NIC, String drivingLicenseNO, String address, String contact) {
        this.setName(name);
        this.setNIC(NIC);
        setDrivingLicenseNO(drivingLicenseNO);
        this.setAddress(address);
        this.setContact(contact);
    }

    public Driver() {
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

}
