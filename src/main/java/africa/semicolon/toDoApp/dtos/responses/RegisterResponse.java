package africa.semicolon.toDoApp.dtos.responses;

public class RegisterResponse {
    private String fullName;

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    private String email;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
