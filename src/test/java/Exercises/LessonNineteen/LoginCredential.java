package Exercises.LessonNineteen;

public class LoginCredential {
    private String email;
    private String password;

    public LoginCredential(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }

}
