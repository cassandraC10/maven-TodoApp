package africa.semicolon.toDoApp.data.models;

import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private List<User> user = new ArrayList<>();

    public User() {

    }
}
