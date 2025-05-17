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

    public Task(String id, String description, LocalDateTime createdAt, boolean done) {
        this.id = id;
        this.createdAt = createdAt;
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
        this.updatedAt = LocalDateTime.parse(LocalDateTime.now().toString());
    }


    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.updatedAt = LocalDateTime.parse(LocalDateTime.now().toString());
        this.done = done;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
