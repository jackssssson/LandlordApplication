package com.daredevil.landlordcommunication.models;

import java.io.Serializable;

public class MessageContent implements Serializable {
    public MessageContent() {
    }

    private int id;
    private byte[] image;
    private String textMessage;
    private ContentType content_types;
    private Messages messages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public ContentType getContent_types() {
        return content_types;
    }

    public void setContent_types(ContentType content_types) {
        this.content_types = content_types;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }
}
