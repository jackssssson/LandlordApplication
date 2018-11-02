package com.daredevil.landlordcommunication.models;

import java.io.Serializable;

public class Messages implements Serializable {
    private String textMessage;
    private String messageType;
    private String timeStamp;

    public Messages() {
    }

    public Messages(String textMessage, String messageType, String timeStamp) {
        this.textMessage = textMessage;
        this.messageType = messageType;
        this.timeStamp = timeStamp;
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

    @Override
    public String toString() {
        return getTextMessage();
    }
}
