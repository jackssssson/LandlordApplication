package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.Date;

public class Messages implements Serializable {
    public Messages() {
    }

    private int id;
    private MessageContent message_content;
    private User sender;
    private User recipient;
    private String timeStamp;

    public Messages(int id, MessageContent message_content, User sender, User recipient, String timeStamp) {
        this.id = id;
        this.message_content = message_content;
        this.sender = sender;
        this.recipient = recipient;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MessageContent getMessage_content() {
        return message_content;
    }

    public void setMessage_content(MessageContent message_content) {
        this.message_content = message_content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
