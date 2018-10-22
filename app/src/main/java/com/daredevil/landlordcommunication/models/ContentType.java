package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.List;

public class ContentType implements Serializable {
    public ContentType() {
    }

    private int id;
    private String contentType;
    private List<MessageContent> message_content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<MessageContent> getMessage_content() {
        return message_content;
    }

    public void setMessage_content(List<MessageContent> message_content) {
        this.message_content = message_content;
    }
}
