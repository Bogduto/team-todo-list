package models;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    private String id;
    private String description;
    private boolean done;
    private String createdAt;
    private String updatedAt;
    // time
    private Date from; // пізніше
    private Date to; // пізніше

    public Task(String id, String description, String createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        done = false;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now().toString();
    }


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.updatedAt = LocalDateTime.now().toString();
        this.done = done;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
