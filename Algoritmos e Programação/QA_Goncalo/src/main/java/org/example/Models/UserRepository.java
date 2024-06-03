package org.example.Models;

import org.example.Domain.User;
import org.example.Tools.LoginReader;

import java.util.ArrayList;

public class UserRepository {
    private static UserRepository instance;
    private ArrayList<User> userArray;

    private UserRepository () {this.userArray = LoginReader.readLoginFile();}

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public ArrayList<User> getUserArray() {return userArray;}
}
