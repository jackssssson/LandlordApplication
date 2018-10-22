package com.daredevil.landlordcommunication.models;

import java.io.Serializable;

public class Address implements Serializable{
    public Address() {
    }

    private int id;
    private String country;
    private String city;
    private String street;
    private int floor;
    private int flat;
    private char entrance;
    private Estates estates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public char getEntrance() {
        return entrance;
    }

    public void setEntrance(char entrance) {
        this.entrance = entrance;
    }

    public Estates getEstates() {
        return estates;
    }

    public void setEstates(Estates estates) {
        this.estates = estates;
    }
}
