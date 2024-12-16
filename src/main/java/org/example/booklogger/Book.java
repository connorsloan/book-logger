package org.example.booklogger;

import java.sql.Timestamp;

public class Book {
    private long id;
    private Timestamp dateCreated;
    private String title;
    private String author;
    private String notes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getTimestamp() {
        return dateCreated;
    }

    public void setTimestamp(String dateCreated) {
        this.dateCreated = Timestamp.valueOf(dateCreated);
    }
}

