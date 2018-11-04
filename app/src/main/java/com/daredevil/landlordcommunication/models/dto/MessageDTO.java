package com.daredevil.landlordcommunication.models.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable{
    private byte[] imageMessage;
    private int senderId;
    private int recipientId;

    public MessageDTO() {
    }

    public MessageDTO(byte[] imageMessage, int senderId, int recipientId) {
        this.imageMessage = imageMessage;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

    public byte[] getImageMessage() {
        return imageMessage;
    }

    public void setImageMessage(byte[] imageMessage) {
        this.imageMessage = imageMessage;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }
}
