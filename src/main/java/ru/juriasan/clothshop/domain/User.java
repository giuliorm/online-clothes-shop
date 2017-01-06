package ru.juriasan.clothshop.domain;

/**
 * Created by GiulioRM on 12/6/2016.
 */
public class User {
    private String email;
    private String password;
    private char role;
    private String firstName;
    private String lastName;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
            return this.email;
    }
    public char getRole() {
        return this.role;
    }
    public void setRole(char role) {
        this.role = role;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

}
