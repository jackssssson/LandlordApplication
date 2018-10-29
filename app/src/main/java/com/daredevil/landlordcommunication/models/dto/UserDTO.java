package com.daredevil.landlordcommunication.models.dto;


import java.io.Serializable;

public class UserDTO implements Serializable{
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userIban;
    private String userType;
    private String userRating;


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
}
