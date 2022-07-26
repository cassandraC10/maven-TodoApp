package africa.semicolon.toDoApp.data.models;
import static africa.semicolon.toDoApp.data.models.Status.*;

import lombok.*;

@Data
public class Task {
    private int id;
    private String task;
    private int date;

    private Status currentStatus = TODO;

    public void onGoing(){
        if (currentStatus == TODO) currentStatus = DOING;
        if (currentStatus == DOING) currentStatus = DOING;
    }
    public void done(){
        if (currentStatus == DOING) currentStatus = DOING;
        if (currentStatus == DONE) currentStatus = DONE;
    }
}

