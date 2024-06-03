package org.example.Domain;

public class Admin extends User{
    private String password;

    public Admin(String username, String password) {
        super("ADMIN", username);
        this.password = password;
    }

    public String getPassword() {return password;}
}
