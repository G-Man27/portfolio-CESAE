package org.example.Controllers;

import org.example.Domain.Admin;
import org.example.Domain.Trainer;
import org.example.Domain.User;
import org.example.Models.UserRepository;

import java.util.ArrayList;

public class LoginController {
    public LoginController() {}

    public User authorizeLogin (String username, String password) {
        ArrayList<User> userArray = UserRepository.getInstance().getUserArray();
        for (User user : userArray) {
            if (user instanceof Trainer trainer) {
                if(username.equals(trainer.getUsername()) && password.equals(trainer.getPassword())) {
                    return trainer;
                }
            } else if (user instanceof Admin admin) {
                if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                    return admin;
                }
            }

            // TODO: VALIDAR LOGIN PLAYER ?????

        }
        return null;
    }
}
