package com.example.splashscreenjpg;

public class CarPark {
    private int carParkId;
    private String name;
    private String email;
    private String address;

    public CarPark(int carParkId) {
        this.carParkId = carParkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
