package com.shutterfly.interview.models;

public class Address {
    private int houseNumber;
    private String streetName;
    private String state;
    private long zipCode;

    public Address() {
    }

    public Address(int houseNumber, String streetName, String state, long zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.state = state;
        this.zipCode = zipCode;
    }


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
