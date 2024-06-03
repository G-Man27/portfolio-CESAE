package org.example.Domain;

public class Trainer extends User{
    private String password;

    public Trainer(String username, String password) {
        super("TREIN", username);
        this.password = password;
    }

    public String getPassword() {return password;}
}
