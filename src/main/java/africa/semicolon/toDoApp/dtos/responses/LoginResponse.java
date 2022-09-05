package africa.semicolon.toDoApp.dtos.responses;

public class LoginResponse {
    private String email;
    private String id;

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setId(String id) { this.id = id; }
    public String getId() {
        return id;
    }
}
