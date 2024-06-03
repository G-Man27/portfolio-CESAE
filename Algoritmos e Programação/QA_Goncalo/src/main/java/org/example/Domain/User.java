package org.example.Domain;

public abstract class User {
    protected String type;
    protected String username;

    public User(String type, String username) {
        this.type = type;
        this.username = username;
    }

    public String getType() {return type;}
    public String getUsername() {return username;}
}
