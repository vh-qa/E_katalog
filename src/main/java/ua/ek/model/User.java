package ua.ek.model;

public class User {

    private String login;
    private String email;
    private String password;
    private String expectedLoginErrorMessage;
    private String expectedEmailErrorMessage;
    private String expectedPasswordErrorMessage;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpectedLoginErrorMessage() {
        return expectedLoginErrorMessage;
    }

    public void setExpectedLoginErrorMessage(String expectedLoginErrorMessage) {
        this.expectedLoginErrorMessage = expectedLoginErrorMessage;
    }

    public String getExpectedEmailErrorMessage() {
        return expectedEmailErrorMessage;
    }

    public void setExpectedEmailErrorMessage(String expectedEmailErrorMessage) {
        this.expectedEmailErrorMessage = expectedEmailErrorMessage;
    }

    public String getExpectedPasswordErrorMessage() {
        return expectedPasswordErrorMessage;
    }

    public void setExpectedPasswordErrorMessage(String expectedPasswordErrorMessage) {
        this.expectedPasswordErrorMessage = expectedPasswordErrorMessage;
    }
}
