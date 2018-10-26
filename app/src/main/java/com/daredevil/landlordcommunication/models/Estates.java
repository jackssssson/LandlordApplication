package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Estates implements Serializable {
    public Estates() {
    }
    private int estateid;
    private String estateName;
    private boolean occupied;
    private float price;
    private String address;
    private Date duedate;


    public Estates(int estateid, String estateName, boolean occupied, float price, String address, Date duedate) {
        this.estateid = estateid;
        this.estateName = estateName;
        this.occupied = occupied;
        this.price = price;
        this.address = address;
        this.duedate = duedate;
    }

    public int getEstateid() {
        return estateid;
    }

    public void setEstateid(int estateid) {
        this.estateid = estateid;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
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

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }
}
