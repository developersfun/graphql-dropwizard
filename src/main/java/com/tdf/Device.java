package com.tdf;

import javax.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name = "device.findAll", query = "select e from Device e")})
@Table(name = "device")
public class Device {

    @Id
    private String device_id;
    private String device_name;
    private String device_brand;
    private String serial_number;
    private String model;

    public String getDevice_id() {
        return device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public String getDevice_brand() {
        return device_brand;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public String getModel() {
        return model;
    }

    public Device(String device_id, String device_name, String device_brand, String serial_number, String model) {
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_brand = device_brand;
        this.serial_number = serial_number;
        this.model = model;
    }

    public Device() {
    }

    @Override
    public String toString() {
        return "Device{" +
                "device_id='" + device_id + '\'' +
                ", device_name='" + device_name + '\'' +
                ", device_brand='" + device_brand + '\'' +
                ", serial_number='" + serial_number + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
