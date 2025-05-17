package models;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    private String id;
    private String description;
    private boolean done;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // time
    private Date from; // пізніше
    private Date to; // пізніше

    public Task(String id, String description, LocalDateTime createdAt, LocalDateTime updatedAt, boolean done) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        setUpdatedAt();
    }


    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
        setUpdatedAt();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
