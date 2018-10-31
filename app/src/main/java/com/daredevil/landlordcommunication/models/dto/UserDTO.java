package com.daredevil.landlordcommunication.models.dto;


import com.daredevil.landlordcommunication.models.Estates;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable{
    private List<Estates> estates;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userIban;
    private String userType;
    private String userRating;

    public UserDTO(List<Estates> estates, String userName,
                   String userPassword, String userEmail, String userIban,
                   String userType, String userRating) {
        this.estates = estates;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userIban = userIban;
        this.userType = userType;
        this.userRating = userRating;
    }

    public UserDTO() {
    }

    public UserDTO(String userName, String userPassword, String userEmail,
                   String userIban) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userIban = userIban;
    }

    public UserDTO(String userName, String userPassword, String userEmail,
                   String userIban, String userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userIban = userIban;
        this.userType = userType;
    }

    public UserDTO(String userName, String userPassword, String userEmail,
                   String userIban, String userType, String userRating) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userIban = userIban;
        this.userType = userType;
        this.userRating = userRating;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserIban() {
        return userIban;
    }

    public void setUserIban(String userIban) {
        this.userIban = userIban;
    }

    public String getType() {
        return userType;
    }

    public void setType(String userType) {
        this.userType = userType;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public List<Estates> getEstates() {
        return estates;
    }

    public void setEstates(List<Estates> estates) {
        this.estates = estates;
    }
}
