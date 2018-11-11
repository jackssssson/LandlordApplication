package com.daredevil.landlordcommunication.models;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.io.Serializable;

public class Messages implements Serializable {
    private String textMessage;
    private String messageType;
    private String timeStamp;
    private UserDTO sender;
    private String imageMessage;

    public Messages() {
    }

    public Messages(String textMessage, String messageType, String timeStamp) {
        this.textMessage = textMessage;
        this.messageType = messageType;
        this.timeStamp = timeStamp;
    }

    public Messages(String textMessage, String messageType, String timeStamp, UserDTO sender) {
        this.textMessage = textMessage;
        this.messageType = messageType;
        this.timeStamp = timeStamp;
        this.sender = sender;
    }

    public Messages(String textMessage, String messageType, String timeStamp,
                    UserDTO sender, String imageMessage) {
        this.textMessage = textMessage;
        this.messageType = messageType;
        this.timeStamp = timeStamp;
        this.sender = sender;
        this.imageMessage = imageMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return getTimeStamp()+ "\n" +sender.getUserName() + ": " + getTextMessage();
    }


    public String getImageMessage() {
        return imageMessage;
    }

    public void setImageMessage(String imageMessage) {
        this.imageMessage = imageMessage;
    }

    public boolean equals(Object o){
        return getClass() == o.getClass();
    }
}
