package africa.semicolon.toDoApp.data.models;

import static africa.semicolon.toDoApp.data.models.Status.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
public class Task {

    private int id;
    private String task;
    private LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime dueDate;
    private Status currentStatus = TODO;



    public void setTask(String task) {
        this.task = task;
    }
    public String getTask() {
        return task;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }
    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public int size() {
        return size();
    }
}

