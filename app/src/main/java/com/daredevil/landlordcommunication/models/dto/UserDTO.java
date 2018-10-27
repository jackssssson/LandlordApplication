package com.daredevil.landlordcommunication.models.dto;



public class UserDTO {
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userIban;

    public UserDTO() {
    }

    public UserDTO(String userName, String userPassword, String userEmail,
                   String userIban) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userIban = userIban;
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
}