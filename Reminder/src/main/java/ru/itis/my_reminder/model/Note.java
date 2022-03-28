package ru.itis.my_reminder.model;

import java.io.Serializable;
import java.time.Instant;

public class Note implements Serializable {
    private Integer id;
    private String text;
    private Instant dateTime;
    private boolean isDone;

    public Note(String text, Instant dateTime, boolean isDone) {
        this.id = null;
        this.text = text;
        this.dateTime = dateTime;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
