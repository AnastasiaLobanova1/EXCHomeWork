package org.example;

public class Smartphone extends Product {
    private String namePhone;
    private String manufacturer;

    public Smartphone(int id, String title, int price, String namePhone, String manufacturer) {
        super(id, title, price);
        this.namePhone = namePhone;
        this.manufacturer = manufacturer;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
