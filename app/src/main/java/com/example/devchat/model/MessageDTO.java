package com.example.devchat.model;

import java.util.Date;

public class MessageDTO {
    private String senderName;
    private String text;
    private Date dateSent;

    public MessageDTO(){}

    public MessageDTO(String senderName, String text, Date date) {
        this.senderName = senderName;
        this.text = text;
        this.dateSent = date;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
}
