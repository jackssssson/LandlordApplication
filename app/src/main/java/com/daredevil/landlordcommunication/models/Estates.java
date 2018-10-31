package com.daredevil.landlordcommunication.models;

import java.io.Serializable;

public class Estates implements Serializable {
    public Estates() {
    }
    private int estateid;
    private boolean occupied;
    private float price;
    private String address;
    private String duedate;


    public Estates(int estateid,  boolean occupied, float price, String address, String duedate) {
        this.estateid = estateid;
        this.occupied = occupied;
        this.price = price;
        this.address = address;
        this.duedate = duedate;
    }

    public Estates(float price, String address) {
        this.price = price;
        this.address = address;
    }

    public int getEstateid() {
        return estateid;
    }

    public void setEstateid(int estateid) {
        this.estateid = estateid;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    @Override
    public String toString() {
        String isOccupied;

        if (isOccupied()){
            isOccupied = "occupied";
        } else {
            isOccupied = "free";
        }

        return getAddress() + " " + getPrice() + " " + isOccupied;
    }
}
