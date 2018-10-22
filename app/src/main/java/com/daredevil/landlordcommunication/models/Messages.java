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
    private Date timeStamp;

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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
