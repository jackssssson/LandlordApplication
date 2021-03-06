package com.daredevil.landlordcommunication.models;

import java.io.Serializable;

public class Estates implements Serializable {
    public Estates() {
    }
    private int estateid;
    private String estateName;
    private boolean occupied;
    private float price;
    private String address;
    private String dueDate;


    public Estates(int estateid,  boolean occupied, float price, String address, String duedate) {
        this.estateid = estateid;
        this.occupied = occupied;
        this.price = price;
        this.address = address;
        this.dueDate = duedate;
    }

    public Estates(String estateName, float price, String address) {
        this.price = price;
        this.address = address;
        this.estateName = estateName;
    }

    public Estates(int estateid, String estateName, boolean occupied, float price, String address, String duedate) {
        this.estateid = estateid;
        this.estateName = estateName;
        this.occupied = occupied;
        this.price = price;
        this.address = address;
        this.dueDate = duedate;
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
        return dueDate;
    }

    public void setDuedate(String duedate) {
        this.dueDate = duedate;
    }

    @Override
    public String toString() {
        String isOccupied;

        if (isOccupied()){
            isOccupied = "occupied";
        } else {
            isOccupied = "free";
        }

        return  getEstateName() + "  " + getAddress() + "  " + getPrice() + "  " + isOccupied;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public boolean equals(Object o){
        return getClass() == o.getClass();
    }

}
